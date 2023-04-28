package quotes;

public class StarChar {
    private final String name;
    private final String eye_color;

    public StarChar(String name, String eye_color) {
        this.name = name;
        this.eye_color = eye_color;
    }

    public String getName() {
        return name;
    }

    public String getEyeColor() {
        return eye_color;
    }

    @Override
    public String toString() {
        return "\"" + eye_color + "\" - " + name;
    }
}
