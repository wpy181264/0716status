package com.dj.ssm.web;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.UserVO;
import com.dj.ssm.service.user.UserService;
import com.dj.ssm.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user/")
public class CRUDController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public ResultModel insert(User user) {
        try {
            // 新增并返回主键
            userService.saveUser(user);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @RequestMapping("/inserts")
    public ResultModel inserts(UserVO userVO) {
        try {
           List<User>Userlist=new ArrayList<>();
            for (User u:userVO.getList()) {
                Userlist.add(u);
            }
            userService.saveBatch(Userlist);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }



    @RequestMapping("/get")
    public ResultModel get(Integer id) {
        try {
            // 根据主键ID获取用户信息
            User user = userService.getById(id);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @RequestMapping("/update")
    public ResultModel update(User user) {
        try {
            // 根据主键ID更新
            userService.updateById(user);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @RequestMapping("/delete/{id}")
    public ResultModel delete(@PathVariable Integer id) {
        try {
            userService.removeById(id);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @RequestMapping("/deleteIds/{ids}")
    public ResultModel deleteIds(@PathVariable Integer[] ids) {
        try {
            List<Integer>list = Arrays.asList(ids);
            userService.removeByIds(list);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    

    @RequestMapping("list")
    public ResultModel list(Integer pageNo, User user, Integer[] userHobby) {
        try {

            // 分页插件的实现原理 SQL拦截器
            IPage<User> page = new Page<>(pageNo, 2);// 当前页,每页条数
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            if (user.getUserName() != null) {
                queryWrapper.like("user_name", user.getUserName());
            }
            if (userHobby != null) {
                queryWrapper.in("user_hobby", userHobby);
            }
            if (user.getUserSex() != null){
                queryWrapper.eq("user_sex", user.getUserSex());
            }
            // 无查询条件可以直接使用 .page(page);
            IPage<User> pageInfo = userService.page(page, queryWrapper);
            System.out.println(pageInfo.getPages());// 总页数
            System.out.println(pageInfo.getRecords());// 数据结果
            System.out.println(pageInfo.getTotal());// 总条数
            return new ResultModel().success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     *正向代理
     * @return
     */
    @RequestMapping("urlShow")
    public ResultModel<Object> urlShow(String url) {
        try {
            String s = HttpClientUtil.sendHttpRequest(url, HttpClientUtil.HttpRequestMethod.GET, null);
            System.out.println(s);
            JSONObject object = JSONObject.parseObject(s);

            return new ResultModel<>().success(object.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }



}
