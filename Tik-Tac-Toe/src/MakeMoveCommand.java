
import java.util.Timer;
import java.util.TimerTask;

public class MakeMoveCommand implements Command {
    private TicTacToe game;
    private CareTaker caretaker;
    private int row, col;
    private Timer timer;
    private boolean isCancelled;

    public MakeMoveCommand(TicTacToe game, CareTaker caretaker, int row, int col) {
        this.game = game;
        this.caretaker = caretaker;
        this.row = row;
        this.col = col;
        this.timer = new Timer();
        this.isCancelled = false;
    }

    @Override
    public void execute() {
        System.out.println("Move scheduled for (" + row + "," + col + "). You have 5 seconds to cancel.");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isCancelled) {
                    game.makeMove(row, col);
                    caretaker.saveState(new Memento(copyBoard(game.getBoard()), game.getCurrentPlayer(), game.getMovesCount()));
                    game.printBoard();
                    if (game.checkWin()) {
                        System.out.println("Player " + game.getCurrentPlayer() + " wins! Congratulations!");
                        System.exit(0);
                    } else if (game.isDraw()) {
                        System.out.println("The game is a draw!");
                        System.exit(0);
                    }
                    game.switchPlayer();
                } else {
                    System.out.println("Move cancelled.");
                }
            }
        }, 5000);
    }

    @Override
    public void cancel() {
        isCancelled = true;
        timer.cancel();
        System.out.println("Move cancelled. Please make a new move.");
    }

    private char[][] copyBoard(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
