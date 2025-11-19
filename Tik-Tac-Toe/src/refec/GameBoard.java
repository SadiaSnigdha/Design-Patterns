package refec;

import java.util.Arrays;

public class GameBoard {
    private char[][] gameGrid;
    private char activePlayer;
    private int moveCount;

    public GameBoard() {
        gameGrid = new char[3][3];
        initializeBoard();
        activePlayer = 'X';
        moveCount = 0;
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(gameGrid[i], ' ');
        }
    }

    public void printBoard() {
        System.out.println("\n  Tic-Tac-Toe Board");
        System.out.println("    0   1   2");
        System.out.println("  +---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameGrid[i][j] + " |");
            }
            System.out.println("\n  +---+---+---+");
        }
        System.out.println();
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && gameGrid[row][col] == ' ';
    }

    public void makeMove(int row, int col) {
        gameGrid[row][col] = activePlayer;
        moveCount++;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][0] == activePlayer && gameGrid[i][1] == activePlayer && gameGrid[i][2] == activePlayer)
                return true;
        }
        for (int j = 0; j < 3; j++) {
            if (gameGrid[0][j] == activePlayer && gameGrid[1][j] == activePlayer && gameGrid[2][j] == activePlayer)
                return true;
        }
        if (gameGrid[0][0] == activePlayer && gameGrid[1][1] == activePlayer && gameGrid[2][2] == activePlayer)
            return true;
        if (gameGrid[0][2] == activePlayer && gameGrid[1][1] == activePlayer && gameGrid[2][0] == activePlayer)
            return true;
        return false;
    }

    public boolean isDraw() {
        return moveCount == 9;
    }

    public void switchPlayer() {
        activePlayer = (activePlayer == 'X') ? 'O' : 'X';
    }

    public char[][] getGameGrid() {
        return gameGrid;
    }

    public char getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(char player) {
        this.activePlayer = player;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int count) {
        this.moveCount = count;
    }
}