package com.example.demo.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseResponse<T> {
    private final boolean success;
    private final int status;
    private final String error;
    private final T body;

    public static <T> BaseResponse<T> of(boolean success, int status, String error, T body) {
        return new BaseResponse<T>(success, status, error, body);
    }
}
