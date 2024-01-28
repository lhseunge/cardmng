package com.seung.cardmng.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ResponseData<T> {

    private int statusCode;
    private T data;
    private String message;

    public ResponseData(T data) {
        this.statusCode = HttpStatus.OK.value();
        this.data = data;
        this.message = "OK";
    }

    public ResponseData(T data, int statusCode) {
        this.statusCode = statusCode;
        this.data = data;
        this.message = "OK";
    }

}
