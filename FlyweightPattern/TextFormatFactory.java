package FlyweightPattern;
import java.util.*;
public class TextFormatFactory {
    private static Map<String, TextFormat> cache = new HashMap<>();

    public static TextFormat getTextFormat(String font, int size, String style) {
        String key = font + size + style;
        return cache.computeIfAbsent(key, k -> new TextFormat(font, size, style));
    }
}
