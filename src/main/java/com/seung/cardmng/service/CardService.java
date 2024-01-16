package com.seung.cardmng.service;

import com.seung.cardmng.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> getCards();
    Card getCard(Integer cardId);
    void saveCard(Card card);

}
