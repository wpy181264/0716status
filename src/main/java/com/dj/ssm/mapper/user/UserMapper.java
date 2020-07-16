package com.dj.ssm.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.UserQuery;
import com.dj.ssm.pojo.UserVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义SQL分页
     *
     * @param page 分页信息
     * @param query 查询条件
     * @return
     */
    // 自定义分页查询的返回值 IPage
    // 自定义分页查询的第一参数必须是IPage,否则将无法分页
    IPage<UserVO> page2(IPage<UserVO> page, @Param("query") UserQuery query);
}
