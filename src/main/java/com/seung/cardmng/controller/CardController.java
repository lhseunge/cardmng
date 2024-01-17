package com.seung.cardmng.controller;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;
import com.seung.cardmng.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cards")
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

    @PostMapping()
    public Card saveCard(@RequestBody CardDto cardDto) {
        return cardService.saveCard(cardDto);
    }
}
