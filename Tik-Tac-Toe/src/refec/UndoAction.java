package refec;

public class UndoAction implements Command {
    private GameBoard game;
    private StateManager stateManager;

    public UndoAction(GameBoard game, StateManager stateManager) {
        this.game = game;
        this.stateManager = stateManager;
    }

    @Override
    public void execute() {
        GameState prevState = stateManager.undo();
        if (prevState != null) {
            restoreState(prevState);
            System.out.println("Undo successful!");
            game.printBoard();
        }
    }

    @Override
    public void cancel() {
        // No cancellation for undo
        System.out.println("Undo action cannot be cancelled.");
    }

    private void restoreState(GameState state) {
        for (int i = 0; i < 3; i++) {
            game.getGameGrid()[i] = state.getGameGrid()[i].clone();
        }
        game.setActivePlayer(state.getActivePlayer());
        game.setMoveCount(state.getMoveCount());
    }
}