public class ResetCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;

    public ResetCommand(TicTacToe game, CareTaker caretaker) {
        this.game = game;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        game.initializeBoard();
        game.setMovesCount(0);
        game.setCurrentPlayer('X');
        caretaker.clear();
        caretaker.saveState(new Memento(copyBoard(game.getBoard()), game.getCurrentPlayer(), game.getMovesCount()));
        System.out.println("Board reset!");
        game.printBoard();
    }

    @Override
    public void cancel() {
        // No cancel for reset
    }

    private char[][] copyBoard(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}