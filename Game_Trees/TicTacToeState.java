import java.util.ArrayList;

/**
 * 
 * @author Kyle Stewart
 * @version 3
 */
public class TicTacToeState implements State {

    String[][] board;
    boolean playerTurn;

    /**
     * 
     * Default constructor. Creates a starting game state.
     * Computer will be X, and player will be O.
     *
     * @param turn Indicates whether it is the player's turn first.
     */
    public TicTacToeState(boolean turn) {
        board = new String[3][3];
        this.playerTurn = turn;
    }

    /**
     * 
     * Copy constructor. Creates a new state by
     * copying the values in the board parameter.
     * Computer will be X, and player will be O.
     *
     * @param board Current game board to be copied.
     * @param turn  Indicates whether it is the player's turn in this state.
     */
    public TicTacToeState(String[][] board, boolean turn) {
        this.board = new String[3][3];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                this.board[r][c] = board[r][c];
            }
        }

        this.playerTurn = turn;
    }

    /**
     *
     * @return "O" if playerTurn is true, "X" otherwise.
     */
    public String getMark() {
        return playerTurn ? "O" : "X";
    }

    /**
     *
     * @return Board.
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     *
     * @return True if it is the human player's turn. (The current turn is "O".)
     */
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    /**
     *
     * @return String representing this state.
     */
    public String toString() {
        String ret = "";
        String bar = " -------------\n";
        ret += bar;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    ret += " |  ";
                } else {
                    ret += " | " + board[r][c];
                }
            }
            ret += " |\n";
            ret += bar;
        }

        return ret;
    }

    /**
     * 
     * Finds all legal moves from the current state.
     *
     * @return ArrayList of moves.
     */
    public ArrayList<State.Move> findAllMoves() {
        ArrayList<State.Move> moves = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    moves.add(new Move(r, c));
                }
            }
        }
        return moves;
    }

    /**
     * 
     * Tests whether the game is over.
     *
     * @return True if game is over.
     */
    public boolean gameOver() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true; // Row win
            }
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                return true; // Column win
            }
        }
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] != null && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return true; // Diagonal win (top-right to bottom-left)
        }

        // Check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    return false; // Game is not over, board has empty space
                }
            }
        }
        return true; // Game is a tie
    }

    /**
     *
     * @return 1 for a win for X, -1 for a loss.
     */
    public int getValue() {
        if (!gameOver()) {
            throw new IllegalStateException("Game is not over.");
        }

        // Implement logic to determine winner or tie
        // Placeholder return value
        return 0;
    }

    /**
     * 
     * Tests whether a move is legal and performs it if so.
     *
     * @param m Move to be done.
     * @return True if move was legal.
     */
    public boolean doMove(State.Move m) {
        if (!(m instanceof Move)) {
            throw new IllegalArgumentException("Invalid move type.");
        }

        Move ticTacToeMove = (Move) m;
        int r = ticTacToeMove.r;
        int c = ticTacToeMove.c;

        if (r < 0 || r >= 3 || c < 0 || c >= 3 || board[r][c] != null) {
            return false; // Invalid move
        }

        board[r][c] = getMark();
        playerTurn = !playerTurn; // Toggle player turn
        return true;
    }

    /**
     * 
     * Undoes the effects of the given move.
     *
     * @param m Move to be undone.
     */
    public void undoMove(State.Move m) {
        if (!(m instanceof Move)) {
            throw new IllegalArgumentException("Invalid move type.");
        }

        Move ticTacToeMove = (Move) m;
        int r = ticTacToeMove.r;
        int c = ticTacToeMove.c;

        if (r < 0 || r >= 3 || c < 0 || c >= 3 || board[r][c] == null) {
            throw new IllegalArgumentException("Invalid move to undo.");
        }

        board[r][c] = null;
        playerTurn = !playerTurn; // Toggle player turn back
    }

    /**
     * 
     * The move class for this game.
     */
    public class Move implements State.Move {

        int r;
        int c;

        /**
         * 
         * @param r Row
         * @param c Column
         */
        public Move(int r, int c) {
            this.r = r;
            this.c = c;
        }

        /**
         *
         * @return String representing this move.
         */
        public String toString() {
            return "row " + r + " column " + c;
        }

        /**
         * 
         * Determine whether this move is equal to another object.
         *
         * @param o Object for comparing
         * @return true if all data from the move matches, false otherwise.
         */
        public boolean equals(Object o) {
            if (o instanceof Move) {
                Move m = (Move) o;

                return m.r == r && m.c == c;
            }

            return false;
        }
    }
}