package com.example.demo.controller.user;

import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getExampleUser();

        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("age", user.getAge());

        modelAndView.setViewName("/user/user");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ModelAndView detailPage(ModelAndView modelAndView) {
        User user = userService.getExampleUser();

        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("age", user.getAge());
        modelAndView.addObject("job", user.getJob());
        modelAndView.addObject("specialty", user.getSpecialty());

        modelAndView.setViewName("/user/detail");
        return modelAndView;
    }
}