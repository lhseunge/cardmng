package com.seung.cardmng.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseData<T> {

    private int statusCode;
    private T data;
    private String message;

    public ResponseData(T data, int statusCode) {
        this.statusCode = statusCode;
        this.data = data;
    }

}
