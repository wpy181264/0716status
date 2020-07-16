package com.dj.ssm.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dj.ssm.mapper.user.UserMapper;
import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.UserQuery;
import com.dj.ssm.pojo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean saveUser(User user) {
        //userMapper.insert(user);
        // getBaseMapper().insert(user);
        this.save(user);
        return true;
    }

    @Override
    public List<UserVO> page2(UserQuery query) {
        // 分页条件
        IPage<UserVO> page = new Page<>(query.getPageNo(), query.getPageSize());
        // 分页后的信息
        IPage<UserVO> pageInfo = getBaseMapper().page2(page, query);
        System.out.println(pageInfo.getPages());// 总页数
        System.out.println(pageInfo.getTotal());// 总条数
        List<UserVO> userVOList = pageInfo.getRecords();// 分页数据
        return userVOList;
    }



}
