package com.example.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String userPage() {
        return "/user/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/detail")
    public String detailPage() {
        return "/user/detail";
    }
}