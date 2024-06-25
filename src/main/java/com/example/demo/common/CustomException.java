package com.example.demo.common;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private String type;

    public CustomException(String type, String cause) {
        super(cause);
        this.type = type;
    }
}
