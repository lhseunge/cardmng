package com.seung.cardmng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    // @GetMapping
    @Deprecated
    public String helloworld() {

        return "hello world";
    }

    @GetMapping()
    public List<String> getCards() {

        return List.of("card 1", "card 2");
    }

    @GetMapping("/{cardId}")
    public String getCard(@PathVariable String cardId) {

        return "card 1";
    }
}
