package com.bansikah.quote_service_travis_ci.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final List<String> backupQuotes = List.of(
            "Code with passion, debug with patience.",
            "First, solve the problem. Then, write the code.",
            "Simplicity is the soul of efficiency.",
            "Your future is created by what you do today."
    );

    public String getQuote() {
        String url = "https://api.quotable.io/random"; // public API
        try {
            QuoteResponse response = restTemplate.getForObject(url, QuoteResponse.class);
            if (response != null && response.getContent() != null) {
                return response.getContent();
            }
        } catch (Exception e) {
            // ignore and fallback
        }
        // Fallback to backup quotes
        Random random = new Random();
        return backupQuotes.get(random.nextInt(backupQuotes.size()));
    }

    // inner DTO class to map API response
    public static class QuoteResponse {
        private String content;

        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }
}
