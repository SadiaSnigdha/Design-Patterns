package refec;

import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        StateManager stateManager = new StateManager();
        stateManager.saveState(new GameState(copyGrid(game.getGameGrid()), game.getActivePlayer(), game.getMoveCount()));

        ActionExecutor executor = new ActionExecutor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Welcome to Tic-Tac-Toe ===");
        System.out.println("Instructions:");
        System.out.println("- Enter move as 'row col' (e.g., '1 2').");
        System.out.println("- Rows/columns are 0, 1, or 2.");
        System.out.println("- Type 'u' to undo a move.");
        System.out.println("- Type 'c' to cancel a pending move.");
        System.out.println("- Type 'r' to reset the game.");
        System.out.println("==============================");
        game.printBoard();

        while (true) {
            System.out.println("Player " + game.getActivePlayer() + "'s turn. Enter move (row col), 'u', 'c', or 'r':");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("u")) {
                executor.setAction(new UndoAction(game, stateManager));
                executor.executeAction();
                continue;
            }

            if (input.equalsIgnoreCase("c")) {
                executor.cancelAction();
                continue;
            }

            if (input.equalsIgnoreCase("r")) {
                executor.setAction(new ResetAction(game, stateManager));
                executor.executeAction();
                continue;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Use 'row col' (e.g., '1 2'), 'u', 'c', or 'r'.");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Row and column must be numbers.");
                continue;
            }

            if (!game.isValidMove(row, col)) {
                System.out.println("Invalid move. Position is out of bounds or already taken.");
                continue;
            }

            Command moveAction = new MoveAction(game, stateManager, row, col);
            executor.setAction(moveAction);
            executor.executeAction();
        }
    }

    private static char[][] copyGrid(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}