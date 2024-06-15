package com.seung.cardmng.dto;

import com.seung.cardmng.entity.Card;
import com.seung.cardmng.service.EncryptService;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class CardDto {

    private String organization;
    private String nickName;
    private String num1;
    private String num2;
    private String num3;
    private String num4;
    private String cvc;
    private int month;
    private int year;
    private boolean credit;
    private String etc;

    public Card toEntity(EncryptService encryptService) {
        return Card.builder()
                .organization(organization)
                .nickName(nickName)
                .num1(encryptService.encrypt(num1))
                .num2(encryptService.encrypt(num2))
                .num3(encryptService.encrypt(num3))
                .num4(encryptService.encrypt(num4))
                .cvc(encryptService.encrypt(cvc))
                .month(month)
                .year(year)
                .credit(credit)
                .insertDate(Instant.now().getEpochSecond())
                .etc(etc)
                .build();
    }
}
