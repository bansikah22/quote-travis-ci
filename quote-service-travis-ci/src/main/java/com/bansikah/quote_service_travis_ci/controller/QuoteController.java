package com.bansikah.quote_service_travis_ci.controller;


import com.bansikah.quote_service_travis_ci.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public String getQuote() {
        return quoteService.getQuote();
    }
}

