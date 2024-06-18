package com.example.demo.controller.user;

import com.example.demo.controller.user.dto.UserDetailResponseDto;
import com.example.demo.controller.user.dto.UserResponseDto;
import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public UserResponseDto userData(@PathVariable Integer id,
                                    @RequestBody @Valid UserResponseOption option) {
        User user = userService.getExampleUser(id);

        return UserResponseDto.of(user, option.getIsShowAge());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/detail")
    public UserDetailResponseDto detailData(@PathVariable Integer id,
                                            @RequestBody @Valid UserResponseOption option) {
        User user = userService.getExampleUser(id);

        return UserDetailResponseDto.of(user, option.getIsShowAge(), option.getIsShowSpecialty());
    }
}