package com.seung.cardmng.service;

import java.util.List;

public interface CardService {

    List<String> getCards();
    String getCard(String cardId);

}
