package quotes;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QuoteTest {

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
        QuotesReader quotesReader = new QuotesReader("https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json");
        Quote randomQuote = quotesReader.getRandomQuote();

        assertNotNull(randomQuote);

    }

    @Test
    public void testInvalidFile() {
        QuotesReader quotesReader = new QuotesReader("https://.json");
        Quote randomQuote = quotesReader.getRandomQuote();

        assertNull(randomQuote);
    }

    @Test
    public void testDisplayQuote() {
        Quote quote = new Quote("Author Name", "Quote text");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "\"Quote text\" - Author Name\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

}

