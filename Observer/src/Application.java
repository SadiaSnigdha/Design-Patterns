public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener(
                "log.txt", "open the file: %s");
        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com", "changed the file");

        editor.events.subscribe("open", logger);
        editor.events.subscribe("save", emailAlerts);

        editor.openFile("demo.txt");
        editor.saveFile();
    }
}
