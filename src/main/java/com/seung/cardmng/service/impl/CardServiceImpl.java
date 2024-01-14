package com.seung.cardmng.service.impl;

import com.seung.cardmng.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public String getCard(String cardId) {

        return "card 1";
    }

    @Override
    public List<String> getCards() {

        return List.of("card 1", "card 2");
    }
}

