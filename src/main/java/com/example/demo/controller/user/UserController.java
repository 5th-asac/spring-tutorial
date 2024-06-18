package com.example.demo.controller.user;

import com.example.demo.controller.user.dto.UserDetailResponseDto;
import com.example.demo.controller.user.dto.UserResponseDto;
import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    @ResponseBody
    public UserResponseDto userData() {
        User user = userService.getExampleUser();

        return UserResponseDto.of(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    @ResponseBody
    public UserDetailResponseDto detailData() {
        User user = userService.getExampleUser();

        return UserDetailResponseDto.of(user);
    }
}