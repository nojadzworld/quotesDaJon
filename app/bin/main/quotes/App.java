package quotes;

public class App {
    public static void main(String[] args) {
        QuotesReader quotesReader = new QuotesReader("https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json");
        Quote randomQuote = quotesReader.getRandomQuote();

        if (randomQuote != null) {
            System.out.println(randomQuote);
        } else {
            System.out.println("No quotes available.");
        }
    }
}