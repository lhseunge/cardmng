package com.seung.cardmng.service.impl;

import com.seung.cardmng.entity.Card;
import com.seung.cardmng.repository.CardRepository;
import com.seung.cardmng.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCard(Integer cardId) {

        // return "card 1";
        return cardRepository.findById(cardId).get();
    }

    @Override
    public List<Card> getCards() {

        // return List.of("card 1", "card 2");
        return cardRepository.findAll();
    }

    @Override
    public void saveCard(Card card) {
        Card savedCard = cardRepository.save(card);

        if (savedCard == null) {
            System.out.println("실패");
        }

        cardRepository.flush();

    }
}

