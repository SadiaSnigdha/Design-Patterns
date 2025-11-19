package refec;

public class GameState {
    private final char[][] gameGrid;
    private final char activePlayer;
    private final int moveCount;

    public GameState(char[][] grid, char player, int count) {
        this.gameGrid = grid;
        this.activePlayer = player;
        this.moveCount = count;
    }

    public char[][] getGameGrid() {
        return gameGrid;
    }

    public char getActivePlayer() {
        return activePlayer;
    }

    public int getMoveCount() {
        return moveCount;
    }
}