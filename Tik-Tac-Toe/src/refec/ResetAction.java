package refec;

public class ResetAction implements Command {
    private GameBoard game;
    private StateManager stateManager;

    public ResetAction(GameBoard game, StateManager stateManager) {
        this.game = game;
        this.stateManager = stateManager;
    }

    @Override
    public void execute() {
        game.initializeBoard();
        game.setMoveCount(0);
        game.setActivePlayer('X');
        stateManager.clear();
        stateManager.saveState(new GameState(copyGrid(game.getGameGrid()), game.getActivePlayer(), game.getMoveCount()));
        System.out.println("Game board reset!");
        game.printBoard();
    }

    @Override
    public void cancel() {
        // No cancellation for reset
        System.out.println("Reset action cannot be cancelled.");
    }

    private char[][] copyGrid(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}