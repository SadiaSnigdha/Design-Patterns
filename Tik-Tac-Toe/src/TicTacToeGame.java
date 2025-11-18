import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        Caretaker caretaker = new Caretaker();

        caretaker.save(game.save());

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Instructions:");
        System.out.println("- Enter your move as two numbers (row and column), each 0, 1, or 2 separated by space.");
        System.out.println("- Type 'u' to undo last move.");
        System.out.println("- Rows and columns are zero-indexed (0 to 2).");
        System.out.println();

        while (true) {
            game.printBoard();
            System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (row col) or 'u' to undo: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid command.");
                continue;
            }

            if (input.equalsIgnoreCase("u")) {
                if (caretaker.canUndo()) {
                    caretaker.undo();
                    TicTacToe.Memento prevState = caretaker.undo();
                    if (prevState != null) {
                        game.restore(prevState);
                        caretaker.save(game.save());
                        System.out.println("Undo successful. Current board:");
                        game.printBoard();
                        System.out.println("Player " + game.getCurrentPlayer() + ", it's your turn.");
                    } else {
                        System.out.println("No previous moves to undo.");
                    }
                } else {
                    System.out.println("Nothing to undo!");
                }
                continue;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please enter row and column separated by space (e.g. '1 2').");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid position! Rows and columns must be 0, 1, or 2.");
                    continue;
                }

                if (!game.placeMark(row, col)) {
                    System.out.println("Position already occupied! Please try another move.");
                    continue;
                }

                caretaker.save(game.save());

                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins! Congratulations!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a tie! Good game.");
                    break;
                }

                game.switchPlayer();

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values for row and column.");
            }
        }

        System.out.println("Thanks for playing Tic-Tac-Toe! Goodbye.");
        scanner.close();
    }
}
