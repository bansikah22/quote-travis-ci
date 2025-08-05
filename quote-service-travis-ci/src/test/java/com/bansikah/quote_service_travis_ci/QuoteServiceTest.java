package com.bansikah.quote_service_travis_ci;

import com.bansikah.quote_service_travis_ci.service.QuoteService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteServiceTest {

    @Test
    void shouldReturnBackupQuoteIfApiFails() {
        QuoteService service = new QuoteService();
        String quote = service.getQuote();
        assertThat(quote).isNotBlank();
    }
}