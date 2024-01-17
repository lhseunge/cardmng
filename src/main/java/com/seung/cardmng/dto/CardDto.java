package com.seung.cardmng.dto;

import com.seung.cardmng.entity.Card;
import lombok.Getter;

@Getter
public class CardDto {

    private String organization;
    private String nickName;
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int cvc;
    private int month;
    private int year;
    private boolean credit;
    private int insertDate;
    private int updateDate;
    private String etc;

    public Card toEntity() {
        return Card.builder()
                .organization(organization)
                .nickName(nickName)
                .num1(num1)
                .num2(num2)
                .num3(num3)
                .num4(num4)
                .cvc(cvc)
                .month(month)
                .year(year)
                .credit(credit)
                .insertDate(insertDate)
                .updateDate(updateDate)
                .etc(etc)
                .build();
    }
}
