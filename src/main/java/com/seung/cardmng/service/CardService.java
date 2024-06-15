package com.seung.cardmng.service;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;

import java.util.List;

public interface CardService {

    List<CardDto> getCards();
    Card getCard(int cardId);
    CardDto saveCard(CardDto cardDto);
    CardDto updateCard(int cardId, CardDto cardDto);
    String deleteCard(int cardId);

}
