package com.dj.ssm.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserTest {

    private Integer id;
    private String userName;
    private List<String>hobby;
    private List<User>userList;
    private Integer money;
}
