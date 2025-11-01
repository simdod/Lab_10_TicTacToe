// Declare Scanner for user input
import java.util.Scanner;

public class TicTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain;

        do
        {
            //Clear the board
            //Set current player to "X"
            //Initialize move counter and gameOver flag
            clearBoard();
            String player = "X";
            int moveCount = 0;
            boolean gameOver = false;

            while (!gameOver)
            {
                //Display the board
                display();
                //Prompt current player for row (1–3) and column (1–3)
                System.out.println("Player " + player + "'s turn.");

                int rowMove = SafeInput.getRangedInt(in, "Enter your row (1-3): ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, "Enter your column (1-3): ", 1, 3) - 1;

                // Validate move
                while (!isValidMove(rowMove, colMove))
                {
                    System.out.println("That spot is already taken. Try again!");
                    rowMove = SafeInput.getRangedInt(in, "Enter your row (1-3): ", 1, 3) - 1;
                    colMove = SafeInput.getRangedInt(in, "Enter your column (1-3): ", 1, 3) - 1;
                }
                //Place player symbol on board
                //move counter
                board[rowMove][colMove] = player;
                moveCount++;

                // Check for a win
                if (isWin(player))
                {
                    display();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                }
                // Check for tie
                else if (isTie())
                {
                    display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                }
                else
                {
                    // Switch player
                    player = (player.equals("X")) ? "O" : "X";
                }
            }
            //Ask user if they want to play again using SafeInput.getYNConfirm()
            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again?");
        }
        while (playAgain);

        System.out.println("Thanks for playing Tic Tac Toe!");
    }
    //clearBoard()
    //Loops through each cell and sets to a space " "
    private static void clearBoard()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                board[r][c] = " ";
            }
        }
    }
    //display()
    //Prints the current board state with grid lines
    private static void display()
    {
        System.out.println();
        for (int r = 0; r < ROWS; r++)
        {
            System.out.print(" ");
            for (int c = 0; c < COLS; c++)
            {
                System.out.print(board[r][c]);
                if (c < COLS - 1) System.out.print(" | ");
            }
            System.out.println();
            if (r < ROWS - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }

    //isValidMove(row, col)
    //Returns true if board[row][col] is a space " "
    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }
    //isWin(player)
    //Returns true if any row, column, or diagonal has all 3 of the player’s marks
    //Calls isRowWin(), isColWin(), isDiagonalWin()
    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    //isRowWin(player)
    //Checks each row for three of the same player symbol
    private static boolean isRowWin(String player)
    {
        for (int r = 0; r < ROWS; r++)
        {
            if (board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player))
                return true;
        }
        return false;
    }

    //isColWin(player)
    //Checks each column for three of the same player symbol
    private static boolean isColWin(String player)
    {
        for (int c = 0; c < COLS; c++)
        {
            if (board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player))
                return true;
        }
        return false;
    }
    //isDiagonalWin(player)
    //Checks both diagonals for three of the same player symbol
    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    //isTie()
    // Returns true if the board is full (no spaces) and no player has won
    private static boolean isTie()
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (board[r][c].equals(" "))
                    return false;
            }
        }
        return true;
    }
}
