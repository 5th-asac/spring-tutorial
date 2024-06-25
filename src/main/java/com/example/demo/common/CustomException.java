package com.example.demo.common;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ExceptionType type;

    public CustomException(ExceptionType type, String cause) {
        super(cause);
        this.type = type;
    }

    public CustomException(ExceptionType type, String cause, Throwable base) {
        super(cause, base);
        this.type = type;
    }

    public CustomException(ExceptionType type, Throwable base) {
        super(base);
        this.type = type;
    }
}
