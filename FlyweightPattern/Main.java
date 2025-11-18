package FlyweightPattern;

public class Main {
    public static void main(String[] args) {
        FormattedCharacter[] chars = {
                new FormattedCharacter('H', TextFormatFactory.getTextFormat("Arial", 12, "Bold")),
                new FormattedCharacter('e', TextFormatFactory.getTextFormat("Arial", 12, "Bold")),
                new FormattedCharacter('l', TextFormatFactory.getTextFormat("Arial", 12, "Bold")),
                new FormattedCharacter('l', TextFormatFactory.getTextFormat("Times", 12, "Italic")),
                new FormattedCharacter('o', TextFormatFactory.getTextFormat("Times", 12, "Italic"))
        };

        for (FormattedCharacter fc : chars) {
            fc.print();
        }
    }
}
