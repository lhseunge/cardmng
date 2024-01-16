package com.seung.cardmng.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "card")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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
    private boolean is_credit;

    @Column
    private int insert_date;

    @Column
    private int update_date;

    @Column
    private String etc;

    @Builder
    public Card(String organization, String nickName, int num1, int num2, int num3, int num4, int cvc, int month, int year, boolean is_credit) {
        this.organization = organization;
        this.nickName = nickName;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.cvc = cvc;
        this.month = month;
        this.year = year;
        this.is_credit = is_credit;
    }
}

