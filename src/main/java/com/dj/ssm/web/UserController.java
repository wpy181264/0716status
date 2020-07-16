package com.dj.ssm.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;

import com.dj.ssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequestMapping("/users/")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResultModel get(@PathVariable Integer id) {
        try {
            User user = userService.getById(id);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @PostMapping
    public ResultModel save(User user) {
        try {
            userService.saveUser(user);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @PutMapping
    public ResultModel update(User user) {
        try {
            userService.updateById(user);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResultModel delete(@PathVariable Integer id) {
        try {
            return new ResultModel().success(userService.removeById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @GetMapping
    public ResultModel list1(Integer pageNo, Integer pageSize) {
        try {
            IPage pageInfo = new Page(pageNo, pageSize);
            IPage<User> page = userService.page(pageInfo);
            return new ResultModel().success(page);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }


    @PostMapping("/list")
    public ResultModel list2(@RequestBody User user) {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("user_name", user.getUserName());
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    @PostMapping("/upload")
    public ResultModel upload(MultipartFile file){
        try {
            //真实文件名
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            //判断是否为空，不为空进行上传
            if(!file.isEmpty()) {
                //定义目录为E:/upload/的文件夹
                String dirPath = "E:/abc/";
                File f = new File(dirPath);
                //如果我们要上传的服务器没有定义的E:/upload/这个文件夹，我们要创建一个
                if(!f.exists()) {
                    f.mkdirs();
                }
                //上传保存
                file.transferTo(new File(dirPath+filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
