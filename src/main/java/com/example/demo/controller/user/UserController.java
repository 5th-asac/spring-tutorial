package com.example.demo.controller.user;

import com.example.demo.controller.user.dto.UserDetailResponseDto;
import com.example.demo.controller.user.dto.UserResponseDto;
import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserResponseDto userData(@PathVariable Integer id,
                                    @RequestParam(required = false, defaultValue = "false") Boolean isShowAge) {
        User user = userService.getExampleUser(id);

        return UserResponseDto.of(user, isShowAge);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/detail")
    public UserDetailResponseDto detailData(@PathVariable Integer id,
                                            @RequestParam(required = false, defaultValue = "false") Boolean isShowAge) {
        User user = userService.getExampleUser(id);

        return UserDetailResponseDto.of(user, isShowAge);
    }
}