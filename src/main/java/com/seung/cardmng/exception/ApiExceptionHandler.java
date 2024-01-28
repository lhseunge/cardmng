package com.seung.cardmng.exception;

import com.seung.cardmng.response.ResponseException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseException handleCustomException(CustomException e, HttpServletRequest httpServletRequest) {

        log.error("URI : {}, CODE : {}", httpServletRequest.getRequestURI(), e.getErrorCode().name());

        return ResponseException.builder()
                .statusCode(e.getErrorCode().getStatusCode())
                .code(e.getErrorCode().name())
                .message(e.getErrorCode().getMessage())
                .build();
    }

}
