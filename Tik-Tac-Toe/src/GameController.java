import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        CareTaker caretaker = new CareTaker();
        caretaker.saveState(new Memento(copyBoard(game.getBoard()), game.getCurrentPlayer(), game.getMovesCount()));

        GameInvoker invoker = new GameInvoker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe with Command & Memento Patterns!");
        game.printBoard();

        while (true) {
            System.out.println("Player " + game.getCurrentPlayer() + ", enter move (row col), 'u' to undo, 'c' to cancel pending move, 'r' to reset:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("u")) {
                invoker.setCommand(new UndoCommand(game, caretaker));
                invoker.executeCommand();
                continue;
            }

            if (input.equalsIgnoreCase("c")) {
                invoker.cancelCommand();
                continue;
            }

            if (input.equalsIgnoreCase("r")) {
                invoker.setCommand(new ResetCommand(game, caretaker));
                invoker.executeCommand();
                continue;
            }

            String[] parts = input.trim().split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input.");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers.");
                continue;
            }

            if (!game.isValidMove(row, col)) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            Command moveCommand = new MakeMoveCommand(game, caretaker, row, col);
            invoker.setCommand(moveCommand);
            invoker.executeCommand();
        }
    }

    private static char[][] copyBoard(char[][] original) {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
