import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Sudoku {
    private Board board;
    private int recursionCount;
    private int backupCount;

    /**
     * 
     * @param sc scanner to read from
     */
    public Sudoku(Scanner sc) {
        board = new Board(sc);
    }

    /**
     * 
     * @param loc location to start at (0,0)
     * @return true if the puzzle is solved, false otherwise
     */
    public boolean solve(Location loc) {
        if (loc == null) {
            return true; // Base case 1: If you are past the end of the board, then all previous
            // locations must have been filled by previous recursive calls, and the puzzle
            // is solved.
        }

        int row = loc.getRow();
        int col = loc.getColumn();

        if (board.get(row, col) != 0) {
            // Recursion case 1: If this location already has a value (from the board file),
            // it should not be changed. Recursively call for the next location.
            return solve(loc.next());
        }

        for (int num = 1; num <= 9; num++) {
            if (board.isAllowed(row, col, num)) {
                board.set(row, col, num);
                recursionCount++;
                if (solve(loc.next())) {
                    return true; // If a solution is found for at least one legal value, return that a solution
                    // was found.
                }
                // If no solution is found for all values for this cell, reset this cell to be
                // empty, and continue to try the next legal value.
                board.set(row, col, 0);
                backupCount++;
            }
        }
        return false; // If no solution is found for all values for this cell, return false.
    }

    /**
     * 
     * @return number of recursive calls made to solve the sudoku
     */
    public int getRecursionCount() {
        return recursionCount;
    }

    /**
     * 
     * @return number of times the board was backed up
     */
    public int getBackupCount() {
        return backupCount;
    }

    /**
     * 
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * 
     * @param args command line argument
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the sudoku file:");
        String fileName = scanner.nextLine();

        try {
            Scanner boardScanner = new Scanner(new File(fileName));
            Sudoku sudoku = new Sudoku(boardScanner);
            System.out.println("Initial configuration of the sudoku");
            System.out.println(sudoku.getBoard());

            Location startLocation = new Location(0, 0);
            if (sudoku.solve(startLocation)) {
                System.out.println("Successful!");
                System.out.println("Final configuration of the sudoku");
                System.out.println(sudoku.getBoard());
                System.out.println("Recursion count = " + sudoku.getRecursionCount());
                System.out.println("Backup count = " + sudoku.getBackupCount());
            } else {
                System.out.println("No solution found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }
}