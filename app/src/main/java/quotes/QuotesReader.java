package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class QuotesReader {
    private List<Quote> quotes;

    public QuotesReader(String filePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            Gson gson = new Gson();
            quotes = gson.fromJson(reader, new TypeToken<List<Quote>>() {
            }.getType());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Quote getRandomQuote() {
        if (quotes == null || quotes.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }

    public Quote getQuoteByAuthor(String author) {
        List<Quote> matchingQuotes = quotes.stream()
                .filter(quote -> quote.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        if (matchingQuotes.isEmpty()) {
            return null;
        }

        return matchingQuotes.get(new Random().nextInt(matchingQuotes.size()));
    }

    public Quote getQuoteContainingWord(String word) {
        List<Quote> matchingQuotes = quotes.stream()
                .filter(quote -> quote.getText().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());

        if (matchingQuotes.isEmpty()) {
            return null;
        }

        return matchingQuotes.get(new Random().nextInt(matchingQuotes.size()));
    }

    public Quote getQuoteByAuthorAndWord(String author, String word) {
        List<Quote> matchingQuotes = quotes.stream()
                .filter(quote -> quote.getAuthor().equalsIgnoreCase(author)
                        && quote.getText().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());

        if (matchingQuotes.isEmpty()) {
            return null;
        }

        return matchingQuotes.get(new Random().nextInt(matchingQuotes.size()));
    }

    public StarChar getRandomStarWarsQuote() throws IOException {


        URL starwarsURL = new URL("https://swapi.tech/api/people/10");
        HttpURLConnection starConnection = (HttpURLConnection) starwarsURL.openConnection();

        starConnection.setRequestMethod("GET");
        int starStatus = starConnection.getResponseCode();
        System.out.println(starStatus);

        if (starStatus == 200) {
            InputStreamReader starStreamReader = new InputStreamReader(starConnection.getInputStream());

            try (BufferedReader starBufferedReader = new BufferedReader(starStreamReader)) {
                String line = starBufferedReader.readLine();
                System.out.println(line);

                Gson starChar = new Gson();
                StarChar fetchedStarChar = starChar.fromJson(line, StarChar.class);

//                    StarChar.add(fetchedStarChar);
                return fetchedStarChar;

            }
        } else {
            System.out.println("person not found");
        }
        return null;
    }

}
