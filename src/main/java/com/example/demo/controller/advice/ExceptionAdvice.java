package com.example.demo.controller.advice;

import com.example.demo.common.BaseResponse;
import com.example.demo.common.CustomException;
import com.example.demo.common.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public BaseResponse custom(CustomException e) {
        log.warn(e.getMessage());
        e.printStackTrace();
        return BaseResponse.failure(e.getType());
    }

    @ExceptionHandler({ Exception.class })
    public BaseResponse custom(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return BaseResponse.failure(ExceptionType.INTERNAL_SERVER_ERROR);
    }
}