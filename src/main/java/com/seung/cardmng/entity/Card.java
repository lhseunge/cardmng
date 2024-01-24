package com.seung.cardmng.entity;

import com.seung.cardmng.dto.CardDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "card")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String organization;

    @Column
    private String nickName;

    @Column
    private int num1;

    @Column
    private int num2;

    @Column
    private int num3;

    @Column
    private int num4;

    @Column
    private int cvc;

    @Column
    private int month;

    @Column
    private int year;

    @Column
    private boolean credit;

    @Column
    private long insertDate;

    @Column
    private long updateDate;

    @Column
    private String etc;

    @Builder(builderMethodName = "updateBuilder")
    public Card(String organization, String nickName, int num1, int num2, int num3, int num4, int cvc, int month, int year, boolean credit, int insertDate, int updateDate, String etc) {
        this.organization = organization;
        this.nickName = nickName;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.cvc = cvc;
        this.month = month;
        this.year = year;
        this.credit = credit;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.etc = etc;
    }

/*
    public Card(String organization, String nickName, int num1, int num2, int num3, int num4, int cvc, int month, int year, boolean credit) {
        this.organization = organization;
        this.nickName = nickName;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.cvc = cvc;
        this.month = month;
        this.year = year;
        this.credit = credit;
    }

    @Builder
    public Card(int id, String organization, String nickName, int num1, int num2, int num3, int num4, int cvc, int month, int year, boolean credit, int insertDate, int updateDate, String etc) {
        this.id = id;
        this.organization = organization;
        this.nickName = nickName;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.cvc = cvc;
        this.month = month;
        this.year = year;
        this.credit = credit;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.etc = etc;
    }

    public Card(Card card) {
        this.organization = card.getOrganization();
        this.nickName = card.getNickName();
        this.num1 = card.getNum1();
        this.num2 = card.getNum2();
        this.num3 = card.getNum3();
        this.num4 = card.getNum4();
        this.cvc = card.getCvc();
        this.month = card.getMonth();
        this.year = card.getYear();
        this.credit = card.isCredit();
        this.insertDate = card.getInsertDate();
        this.updateDate = card.getUpdateDate();
        this.etc = card.getEtc();
    }

*/
    public CardDto toDto() {
        return CardDto.builder()
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
                .etc(etc)
                .build();
    }


}

