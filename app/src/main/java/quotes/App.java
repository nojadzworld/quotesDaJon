package quotes;

public class App {

    public static void main(String[] args) {
        QuotesReader quotesReader = new QuotesReader("/Users/camerongriffin/projects/courses/401/quotes/app/src/main/resources/recentquotes.json");
        Quote randomQuote = quotesReader.getRandomQuote();

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