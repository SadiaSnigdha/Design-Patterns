import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String path) {
        this.file = new File(path);
        System.out.println("Opened file: " + file.getName());
        events.notify("open", file.getName());
    }

    public void saveFile() {
        if (this.file != null) {
            System.out.println("Saved file: " + file.getName());
            events.notify("save", file.getName());
        } else {
            System.out.println("No file opened to save.");
        }
    }
}
