package com.example.demo.controller.user;

import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String userPage(ModelMap model) {
        User user = userService.getExampleUser();

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());

        return "/user/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String detailPage(ModelMap model) {
        User user = userService.getExampleUser();

        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("job", user.getJob());
        model.addAttribute("specialty", user.getSpecialty());

        return "/user/detail";
    }
}