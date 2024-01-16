package com.seung.cardmng.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@EntityScan
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
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

}

