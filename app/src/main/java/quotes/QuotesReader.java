package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuotesReader {
    private List<Quote> quotes;

    public QuotesReader(String filePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            Gson gson = new Gson();
            quotes = gson.fromJson(reader, new TypeToken<List<Quote>>(){}.getType());
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

    // Update the access modifier to public
    public Quote getRandomStarChar() throws IOException {
        URL starURL = new URL("https://swapi.tech/api/people/10");
        HttpURLConnection starConnection = (HttpURLConnection) starURL.openConnection();
        starConnection.setRequestMethod("GET");
        int starStatus = starConnection.getResponseCode();

        if (starStatus == 200) {
            InputStreamReader starStreamReader = new InputStreamReader(starConnection.getInputStream());
            try (BufferedReader starBufferedReader = new BufferedReader(starStreamReader)) {
                String line = starBufferedReader.readLine();
                Gson starSon = new Gson();
                StarChar starChar = starSon.fromJson(line, StarChar.class);
                return new Quote(starChar.getName(), "Eye color: " + starChar.getEye_color());
            }
        } else {
            throw new IOException("Error fetching Star Wars character from API.");
        }
    }
}
