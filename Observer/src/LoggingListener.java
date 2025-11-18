import java.io.FileWriter;
import java.io.IOException;

public class LoggingListener implements EventListener {
    private String logFile;
    private String message;

    public LoggingListener(String logFile, String message) {
        this.logFile = logFile;
        this.message = message;
    }

    @Override
    public void update(String filename) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            String output = message.replace("%s", filename);
            writer.write(output + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
