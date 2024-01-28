package com.seung.cardmng.exception;

import com.seung.cardmng.common.CustomException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    public CustomException handleCustomException()

}
