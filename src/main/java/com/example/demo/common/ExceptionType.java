package com.example.demo.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionType {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_EXIST(HttpStatus.NOT_FOUND, "존재하지 않는 리소스입니다.");

    private final HttpStatus status;
    private final String message;

    private ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
