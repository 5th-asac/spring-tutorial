package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

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

    public static <T> BaseResponse<T> created() {
        return BaseResponse.of(true, HttpStatus.CREATED.value(), null, null);
    }

    public static <T> BaseResponse<T> success() {
        return BaseResponse.of(true, HttpStatus.NO_CONTENT.value(), null, null);
    }

    public static <T> BaseResponse<T> success(T body) {
        return BaseResponse.of(true, HttpStatus.OK.value(), null, body);
    }

    public static <T> BaseResponse<T> failure(ExceptionType type) {
        return BaseResponse.of(false, type.getStatus().value(), type.getMessage(), null);
    }
}
