package com.seung.cardmng.common;

import com.seung.cardmng.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private int statusCode;
    private String message;

    public CustomException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public CustomException(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatusCode();
        this.message = errorCode.getMessage();
    }
}
