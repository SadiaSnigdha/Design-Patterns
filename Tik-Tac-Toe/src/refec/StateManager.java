package refec;

import java.util.ArrayDeque;
import java.util.Deque;

public class StateManager {
    private Deque<GameState> stateHistory = new ArrayDeque<>();

    public void saveState(GameState state) {
        stateHistory.push(state);
    }

    public GameState undo() {
        if (stateHistory.size() <= 1) {
            System.out.println("No previous moves to undo.");
            return null;
        }
        stateHistory.pop();
        return stateHistory.peek();
    }

    public void clear() {
        stateHistory.clear();
    }
}