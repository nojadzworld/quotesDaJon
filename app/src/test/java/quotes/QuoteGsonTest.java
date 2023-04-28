package quotes;


import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuoteGsonTest {

    @Test
    public void testGetRandomStarWarsQuote() throws IOException {
        Gson gson = new Gson();
        StarWarsQuoteGenerator generator = new StarWarsQuoteGenerator();
        String jsonString = generator.getRandomStarWarsQuote().toJsonString;

        assertNotNull(jsonString, "String should not be empty!");

        Quote quote = gson.fromJson(jsonString, Quote.class);

        assertNotNull(quote.getAuthor(), "Author should not be empty!");

    }

}
