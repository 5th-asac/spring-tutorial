package com.example.demo.controller.user;

import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String userPage() {
        User user = userService.getExampleUser();
        System.out.println(user);
        return "/user/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detailPage() {
        User user = userService.getExampleUser();
        System.out.println(user);
        return "/user/detail";
    }
}