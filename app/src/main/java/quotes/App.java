package quotes;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote quote;

        try {
            quote = quotesReader.getRandomStarChar();
        } catch (IOException e) {
            System.out.println("Failed to fetch Star Wars character from API. Falling back to local JSON file.");
            quote = quotesReader.getRandomQuote();
        }

        displayQuote(quote);
    }

    public static void displayQuote(Quote quote) {
        if (quote != null) {
            System.out.println(quote);
        } else {
            System.out.println("No quotes available.");
        }
    }
}
