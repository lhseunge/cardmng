package com.seung.cardmng.service.impl;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;
import com.seung.cardmng.exception.CustomException;
import com.seung.cardmng.exception.ErrorCode;
import com.seung.cardmng.repository.CardRepository;
import com.seung.cardmng.service.CardService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCard(int cardId) {

        return cardRepository.findById(cardId).orElseThrow(() -> new CustomException(ErrorCode.CARD_NOT_FONUD));
    }

    @Override
    public List<Card> getCards() {

        return cardRepository.findAll();
    }

    @Override
    public Card saveCard(CardDto cardDto) {

        Card card = cardDto.toEntity();

        Card savedCard = cardRepository.save(card);

        if (savedCard == null) {
            System.out.println("실패");
        }

        cardRepository.flush();

        return card;
    }

    @Override
    public Card updateCard(int cardId, CardDto cardDto) {

        Card card = Card.builder()
                .id(cardId)
                .organization(cardDto.getOrganization())
                .nickName(cardDto.getNickName())
                .num1(cardDto.getNum1())
                .num2(cardDto.getNum2())
                .num3(cardDto.getNum3())
                .num4(cardDto.getNum4())
                .cvc(cardDto.getCvc())
                .month(cardDto.getMonth())
                .year(cardDto.getYear())
                .credit(cardDto.isCredit())
                .updateDate(Instant.now().getEpochSecond())
                .etc(cardDto.getEtc())
                .build();

        return cardRepository.save(card);
    }

    @Override
    public String deleteCard(int cardId) {

        cardRepository.deleteById(cardId);

        return "delete successful";
    }
}

