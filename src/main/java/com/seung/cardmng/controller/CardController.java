package com.seung.cardmng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    @GetMapping
    public String helloworld() {

        return "hello world";
    }
}
