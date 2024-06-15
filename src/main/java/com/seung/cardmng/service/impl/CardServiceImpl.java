package com.seung.cardmng.service.impl;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;
import com.seung.cardmng.exception.CustomException;
import com.seung.cardmng.exception.ErrorCode;
import com.seung.cardmng.repository.CardRepository;
import com.seung.cardmng.service.CardService;
import com.seung.cardmng.service.EncryptService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final EncryptService encryptService;

    public CardServiceImpl(
            CardRepository cardRepository,
            EncryptService encryptService) {
        this.cardRepository = cardRepository;
        this.encryptService = encryptService;
    }

    @Override
    public Card getCard(int cardId) {

        return cardRepository.findById(cardId).orElseThrow(() -> new CustomException(ErrorCode.CARD_NOT_FONUD));
    }

    @Override
    public List<CardDto> getCards() {

        return cardRepository.findAll().stream()
                .map(card -> card.toDto(encryptService))
                .collect(Collectors.toList());
    }

    @Override
    public CardDto saveCard(CardDto cardDto) {

        Card card = cardDto.toEntity(encryptService);

        Card savedCard = cardRepository.save(card);

        if (savedCard == null) {
            throw new CustomException(ErrorCode.FAIL_SAVE_CARD);
        }

        cardRepository.flush();

        return card.toDto(encryptService);
    }

    @Override
    public CardDto updateCard(int cardId, CardDto cardDto) {

        Card card = Card.builder()
                .id(cardId)
                .organization(cardDto.getOrganization())
                .nickName(cardDto.getNickName())
                .num1(encryptService.encrypt(cardDto.getNum1()))
                .num2(encryptService.encrypt(cardDto.getNum2()))
                .num3(encryptService.encrypt(cardDto.getNum3()))
                .num4(encryptService.encrypt(cardDto.getNum4()))
                .cvc(encryptService.encrypt(cardDto.getCvc()))
                .month(cardDto.getMonth())
                .year(cardDto.getYear())
                .credit(cardDto.isCredit())
                .updateDate(Instant.now().getEpochSecond())
                .etc(cardDto.getEtc())
                .build();

        return cardRepository.save(card)
                .toDto(encryptService);
    }

    @Override
    public String deleteCard(int cardId) {

        cardRepository.deleteById(cardId);

        return "delete successful";
    }
}

