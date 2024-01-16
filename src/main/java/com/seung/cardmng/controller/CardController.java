package com.seung.cardmng.controller;

import com.seung.cardmng.entity.Card;
import com.seung.cardmng.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // @GetMapping
    @Deprecated
    public String helloworld() {

        return "hello world";
    }

    @GetMapping()
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @GetMapping("/{cardId}")
    public Card getCard(@PathVariable Integer cardId) {
        return cardService.getCard(cardId);
    }
}
