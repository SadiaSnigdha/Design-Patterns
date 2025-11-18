package FlyweightPattern;

public class FormattedCharacter {
    char character;
    TextFormat format;

    public FormattedCharacter(char character, TextFormat format) {
        this.character = character;
        this.format = format;
    }

    public void print() {
        System.out.println("Char: " + character + " | Format: " + format);
    }
}
