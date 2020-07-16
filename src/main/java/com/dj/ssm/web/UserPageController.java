package com.dj.ssm.web;

import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Mybatis-Plus 分页操作
 */
@Controller
@RequestMapping("/user/")
public class UserPageController {

    @Autowired
    private UserService userService;

    @RequestMapping("toAdd")
    public String toAdd() {
        return "/user/add";
    }

    @RequestMapping("toAdds")
    public String toAdds() {
        return "/user/adds";
    }

    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/user/update";
    }


}
