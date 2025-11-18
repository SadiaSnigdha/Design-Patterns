package Bridge;

public class PDFformatter  implements Formatter {
    public void format(String title, String content) {
        System.out.println("PDF Format: [" + title + "] => " + content);
    }
}
