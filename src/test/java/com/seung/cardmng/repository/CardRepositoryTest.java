package com.seung.cardmng.repository;

import com.seung.cardmng.entity.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void 카드_저장() {
        String nickname = "테스트";

        Card card = Card.builder()
                .organization("카드사")
                .nickName(nickname)
                .num1(1)
                .num2(2)
                .num3(3)
                .num4(4)
                .cvc(123)
                .month(12)
                .year(30)
                .credit(false)
                .build();

        Card savedCard = cardRepository.save(card);

        Assertions.assertEquals(nickname, savedCard.getNickName());

    }

//    @Test
    public void 카드_수정() {
        int cardId = 1;

        // 1번 카드 조회
        Card card = cardRepository.findById(cardId).get();

        // 1번 카드 닉네임
        String cardNickname = card.getNickName();

        // 수정할 카드 엔티티 생성 from 1번 카드 엔티티
        Card upCard = Card.builder()
                .id(cardId)
                .organization(card.getOrganization())
                .nickName("수정 후 - " + card.getNickName())
                .num1(card.getNum1())
                .num2(card.getNum2())
                .num3(card.getNum3())
                .num4(card.getNum4())
                .cvc(card.getCvc())
                .month(card.getMonth())
                .year(card.getYear())
                .credit(card.isCredit())
                .insertDate(card.getInsertDate())
                .updateDate(card.getUpdateDate())
                .etc(card.getEtc())
                .build();

        Card updatedCard = cardRepository.save(upCard);

        String updatedCardNickname = updatedCard.getNickName();

        Assertions.assertNotEquals(cardNickname, updatedCardNickname);

    }

}
