package com.seung.cardmng.controller;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;
import com.seung.cardmng.service.CardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cards")
@Tag(name = "카드 API", description = "카드 CRUD")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
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

    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable int cardId, @RequestBody CardDto cardDto) {
        return cardService.updateCard(cardId, cardDto);
    }

    @DeleteMapping("/{cardId}")
    public String deleteCard(@PathVariable int cardId) {
        return cardService.deleteCard(cardId);
    }
}
