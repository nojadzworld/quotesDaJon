package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
}