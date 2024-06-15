package com.seung.cardmng.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SUCCESS(HttpStatus.OK.value(), "OK"),

    CARD_NOT_FONUD(HttpStatus.BAD_REQUEST.value(), "카드를 찾을 수 없습니다."),
    FAIL_SAVE_CARD(HttpStatus.INTERNAL_SERVER_ERROR.value(), "카드 저장 실패"),

    ;

    private final int statusCode;
    private final String message;

}
