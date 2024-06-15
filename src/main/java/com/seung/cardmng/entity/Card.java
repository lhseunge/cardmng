package com.seung.cardmng.entity;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.service.EncryptService;
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
    private String num1;

    @Column
    private String num2;

    @Column
    private String num3;

    @Column
    private String num4;

    @Column
    private String cvc;

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

    public CardDto toDto(EncryptService encryptService) {
        return CardDto.builder()
                .organization(organization)
                .nickName(nickName)
                .num1(encryptService.decrypt(num1))
                .num2(encryptService.decrypt(num2))
                .num3(encryptService.decrypt(num3))
                .num4(encryptService.decrypt(num4))
                .cvc(encryptService.decrypt(cvc))
                .month(month)
                .year(year)
                .credit(credit)
                .etc(etc)
                .build();
    }


}

