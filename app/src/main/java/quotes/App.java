package quotes;


import java.io.IOException;

public class App {

    public static void main(String[] args) {

        QuotesReader quotesReader = new QuotesReader("./app/src/main/resources/recentquotes.json");
        Quote randomQuote = null;


        try {
            randomQuote = quotesReader.getRandomStarWarsQuote();

        }catch (IOException e) {
            System.out.println("failed to connect to api");
            randomQuote = quotesReader.getRandomQuote();
        }

        displayQuote(randomQuote);
    }

    public static void displayQuote(Quote randomQuote) {
        if (randomQuote != null) {
            System.out.println(randomQuote);
        } else {
            System.out.println("No quotes available.");
        }
    }


}