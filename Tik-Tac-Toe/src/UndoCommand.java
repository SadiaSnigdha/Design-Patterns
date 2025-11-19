public class UndoCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;

    public UndoCommand(TicTacToe game, CareTaker caretaker) {
        this.game = game;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        Memento prevState = caretaker.undo();
        if (prevState != null) {
            restoreState(prevState);
            game.printBoard();
        }
    }

    @Override
    public void cancel() {
        // No cancel for undo
    }

    private void restoreState(Memento memento) {
        for (int i = 0; i < 3; i++) {
            game.getBoard()[i] = memento.getBoard()[i].clone();
        }
        game.setCurrentPlayer(memento.getPlayer());
        game.setMovesCount(memento.getMovesCount());
    }
}