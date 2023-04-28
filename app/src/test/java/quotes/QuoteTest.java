package quotes;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuoteTest {

    @Test
    public void testQuoteCreation() {
        Quote quote = new Quote("Author Name", "Quote text");

        assertEquals("Author Name", quote.getAuthor());
        assertEquals("Quote text", quote.getText());
    }

    @Test
    public void testQuoteToString() {
        Quote quote = new Quote("Author Name", "Quote text");

        assertEquals("\"Quote text\" - Author Name", quote.toString());
    }

    @Test
    public void testGetRandomQuote() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote randomQuote = quotesReader.getRandomQuote();

        assertNotNull(randomQuote);
    }

    @Test
    public void testInvalidFile() {
        QuotesReader quotesReader = new QuotesReader("nonfile.json");
        Quote randomQuote = quotesReader.getRandomQuote();

        assertNull(randomQuote);
    }

    @Test
    public void testGetQuoteByAuthor() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteByAuthor = quotesReader.getQuoteByAuthor("Charles Dickens");

        assertNotNull(quoteByAuthor);
        assertEquals("Charles Dickens", quoteByAuthor.getAuthor());
    }

    @Test
    public void testGetQuoteContainingWord() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteContainingWord = quotesReader.getQuoteContainingWord("liberty");

        assertNotNull(quoteContainingWord);
        assertTrue(quoteContainingWord.getText().toLowerCase().contains("liberty"));
    }

    @Test
    public void testGetQuoteByAuthorAndWord() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteByAuthorAndWord = quotesReader.getQuoteByAuthorAndWord("Charles Dickens", "March");

        assertNotNull(quoteByAuthorAndWord);
        assertEquals("Charles Dickens", quoteByAuthorAndWord.getAuthor());
        assertTrue(quoteByAuthorAndWord.getText().toLowerCase().contains("march"));
    }

    @Test
    public void testGetQuoteByNonexistentAuthor() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteByAuthor = quotesReader.getQuoteByAuthor("Nonexistent Author");

        assertNull(quoteByAuthor);
    }

    @Test
    public void testGetQuoteContainingNonexistentWord() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteContainingWord = quotesReader.getQuoteContainingWord("nonexistentword");

        assertNull(quoteContainingWord);
    }

    @Test
    public void testGetQuoteByAuthorAndNonexistentWord() {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quoteByAuthorAndWord = quotesReader.getQuoteByAuthorAndWord("Charles Dickens", "nonexistentword");

        assertNull(quoteByAuthorAndWord);
    }

    @Test
    public void testGetRandomStarWarsQuote() throws IOException {
        QuotesReader generator = new QuotesReader();
        Quote quote = generator.getRandomStarWarsQuote();
        assertNotNull(quote);
    }
}