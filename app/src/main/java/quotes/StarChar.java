package quotes;

public class StarChar {
    private String name;
    private String eye_color;

    public StarChar(String name, String eye_color) {
        this.name = name;
        this.eye_color = eye_color;
    }

    public String getName() {
        return name;
    }


    public String getEye_color() {
        return eye_color;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Eye Color: " + eye_color;
    }

}
