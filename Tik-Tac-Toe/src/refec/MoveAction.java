package refec;

import java.util.Timer;
import java.util.TimerTask;

public class MoveAction implements Command {
    private GameBoard game;
    private StateManager stateManager;
    private int row, col;
    private Timer timer;
    private boolean isCancelled;

    public MoveAction(GameBoard game, StateManager stateManager, int row, int col) {
        this.game = game;
        this.stateManager = stateManager;
        this.row = row;
        this.col = col;
        this.timer = new Timer();
        this.isCancelled = false;
    }

    @Override
    public void execute() {
        System.out.println("Move scheduled at position (" + row + ", " + col + "). You have 5 seconds to cancel with 'c'.");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isCancelled) {
                    game.makeMove(row, col);
                    stateManager.saveState(new GameState(copyGrid(game.getGameGrid()), game.getActivePlayer(), game.getMoveCount()));
                    game.printBoard();
                    if (game.checkWin()) {
                        System.out.println("Player " + game.getActivePlayer() + " wins! Game over!");
                    } else if (game.isDraw()) {
                        System.out.println("Game ends in a draw!");
                    } else {
                        game.switchPlayer();
                    }
                } else {
                    System.out.println("Move at (" + row + ", " + col + ") was cancelled.");
                }
            }
        }, 5000);
    }

    @Override
    public void cancel() {
        isCancelled = true;
        timer.cancel();
        System.out.println("Move at (" + row + ", " + col + ") cancelled. Please enter a new move.");
    }

    private char[][] copyGrid(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}