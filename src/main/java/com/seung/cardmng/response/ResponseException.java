package com.seung.cardmng.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseException {

    private int statusCode;
    private String code;
    private String message;

}
