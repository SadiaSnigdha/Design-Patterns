package Bridge;

public class CSVformatter implements Formatter {
    public void format(String title, String content) {
        System.out.println("CSV Format: " + title + "," + content);
    }
}
