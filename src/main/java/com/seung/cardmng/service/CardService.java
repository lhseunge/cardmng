package com.seung.cardmng.service;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> getCards();
    Card getCard(Integer cardId);
    Card saveCard(CardDto cardDto);
    Card updateCard(CardDto cardDto);

}
