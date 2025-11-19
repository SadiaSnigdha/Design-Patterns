import java.util.ArrayDeque;
import java.util.Deque;

public class CareTaker {
    private Deque<Memento> history = new ArrayDeque<>();

    public void saveState(Memento memento) {
        history.push(memento);
    }

    public Memento undo() {
        if (history.size() <= 1) {
            System.out.println("Cannot undo, no previous moves.");
            return null;
        }
        history.pop();
        return history.peek();
    }

    public void clear() {
        history.clear();
    }
}
