package FlyweightPattern;

public class TextFormat {
    String font;
    int size;
    String style;

    public TextFormat(String font, int size, String style) {
        this.font = font;
        this.size = size;
        this.style = style;
    }

    @Override
    public String toString() {
        return font + ", " + size + "pt, " + style;
    }
}