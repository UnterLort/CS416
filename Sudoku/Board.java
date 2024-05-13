import java.util.Scanner;

/**
 * 
 * @author Kyle Stewart
 * @version 2
 */
public class Board {
    private int[][] board;

    /**
     * 
     * @param sc Scanner to read from the file
     */
    public Board(Scanner sc) {
        board = readBoard(sc);
    }

    /**
     * 
     * @param sc Scanner to read from the file
     * @return 2D array of the board
     */
    public static int[][] readBoard(Scanner sc) {
        int[][] result = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            if (line.length() != 9) {
                return null;
            }
            for (int j = 0; j < 9; j++) {
                char ch = line.charAt(j);
                if (ch == '-') {
                    result[i][j] = 0;
                } else if (ch >= '1' && ch <= '9') {
                    result[i][j] = ch - '0';
                } else {
                    return null;
                }
            }
        }
        return result;
    }

    /**
     * 
     * @param row row
     * @param col column
     * @return value at the given row and column
     */
    public int get(int row, int col) {
        return board[row][col];
    }

    /**
     * 
     * @param row   row
     * @param col   column
     * @param value to set
     */
    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    /**
     * 
     * @param row    row
     * @param number number to check
     * @return true if the number is in the row
     */
    public boolean containsInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param col    column
     * @param number number to check
     * @return true if the number is in the column
     */
    public boolean containsInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param row    row
     * @param col    column
     * @param number to check
     * @return true if the number is in the box
     */
    public boolean containsInBox(int row, int col, int number) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param row    row
     * @param col    column
     * @param number number to check
     * @return true if the number is allowed in the row, column and box
     */
    public boolean isAllowed(int row, int col, int number) {
        return !containsInRow(row, number) && !containsInCol(col, number)
                && !containsInBox(row, col, number) && board[row][col] == 0;
    }

    /**
     * 
     * @return board as a string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-------+-------+-------+\n");
        for (int i = 0; i < 9; i++) {
            if (i > 0 && i % 3 == 0) {
                sb.append("+-------+-------+-------+\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    sb.append("| ");
                }
                if (board[i][j] == 0) {
                    sb.append("- ");
                } else {
                    sb.append(board[i][j]).append(" ");
                }
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+\n");
        return sb.toString();
    }
}