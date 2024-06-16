package com.example.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String userPage() {
        return "/user/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detailPage() {
        return "/user/detail";
    }
}