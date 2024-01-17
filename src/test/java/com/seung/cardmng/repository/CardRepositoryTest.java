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
    public void 카드저장() {
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
}
