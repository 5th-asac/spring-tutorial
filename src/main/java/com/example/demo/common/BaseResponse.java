package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"isSuccess", "body", "error"})
public class BaseResponse<T> {
    @JsonProperty("isSuccess")
    private final boolean success;
    @JsonIgnore
    private final int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T body;

    public static <T> BaseResponse<T> of(boolean success, int status, String error, T body) {
        return new BaseResponse<T>(success, status, error, body);
    }
}
