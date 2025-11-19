
public class Memento {
    private final char[][] board;
    private final char player;
    private final int movesCount;

    public Memento(char[][] board, char player, int movesCount) {
        this.board = board;
        this.player = player;
        this.movesCount = movesCount;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getPlayer() {
        return player;
    }

    public int getMovesCount() {
        return movesCount;
    }
}
