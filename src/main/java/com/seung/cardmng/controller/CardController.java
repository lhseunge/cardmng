package com.seung.cardmng.controller;

import com.seung.cardmng.dto.CardDto;
import com.seung.cardmng.entity.Card;
import com.seung.cardmng.response.ResponseData;
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
    public ResponseData<List<CardDto>> getCards() {
        return new ResponseData<>(cardService.getCards());
    }

    @GetMapping("/{cardId}")
    public ResponseData<Card> getCard(@PathVariable int cardId) {
        return new ResponseData<>(cardService.getCard(cardId));
    }

    @PostMapping()
    public ResponseData<Card> saveCard(@RequestBody CardDto cardDto) {
        return new ResponseData<>(cardService.saveCard(cardDto));
    }

    @PutMapping("/{cardId}")
    public ResponseData<Card> updateCard(@PathVariable int cardId, @RequestBody CardDto cardDto) {
        return new ResponseData<>(cardService.updateCard(cardId, cardDto));
    }

    @DeleteMapping("/{cardId}")
    public ResponseData<String> deleteCard(@PathVariable int cardId) {
        return new ResponseData<>(cardService.deleteCard(cardId));
    }
}
