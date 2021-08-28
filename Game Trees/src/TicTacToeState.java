import java.util.ArrayList;

public class TicTacToeState implements State {

    String[][] board;
    boolean playerTurn;

    /**
     * Default constructor. Creates a starting game state.
     * Computer will be X, and player will be O.
     *
     * @param turn Indicates whether it is the player's turn first.
     */
    public TicTacToeState( boolean turn ){
        board = new String[3][3];
        this.playerTurn = turn;
    }


    /**
     * Copy constructor. Creates a new state by
     * copying the values in the board and turn parameters.
     * Computer will be X, and player will be O.
     *
     * @param board The current game board to be copied.
     * @param turn Indicates whether it is the player's turn in this state.
     */
    public TicTacToeState( String[][] board, boolean turn ){
        this.board = new String[3][3];

        for( int r = 0; r < board.length; r++ ){
            for( int c = 0; c < board[r].length; c++ ){
                this.board[r][c] = board[r][c];
            }
        }

        this.playerTurn = turn;
    }

    /**
     * Returns the mark for the player whose turn it is in this state.
     *
     * @return "O" if playerTurn is true, "X" otherwise.
     */
    public String getMark(){
        return playerTurn ? "O" : "X";
    }

    /**
     * Returns the board for this state.
     *
     * @return The board.
     */
    public String[][] getBoard(){
        return board;
    }

    /**
     * Returns whether it is the human player's turn or not.
     *
     * @return true if it is the human player's turn. (The current turn is "O".)
     */
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    /**
     * Returns a string representation of this state.
     *
     * @return The string representing this state.
     */
    public String toString(){
        String ret = "";
        String bar = " -------------\n";
        ret += bar;

        for( int r = 0; r < board.length; r++ ) {
            for (int c = 0; c < board[r].length; c++) {
                if( board[r][c] == null ) {
                    ret += " |  ";
                }
                else{
                    ret += " | " + board[r][c];
                }
            }
            ret += " |\n";
            ret += bar;
        }

        return ret;
    }

    /**
     * Finds all legal moves from the current state.
     *
     * @return ArrayList of moves.
     */
    public ArrayList<State.Move> findAllMoves() {
        ArrayList<State.Move> legalmoves = new ArrayList<State.Move>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    Move legalmove = new Move(r,c);
                    legalmoves.add(legalmove);
                }
            }
        }
        return legalmoves;
    }

    /**
     * Tests whether the game is over.
     *
     * @return true if game is over, false otherwise.
     */
    public boolean gameOver() {
        boolean isOver = true;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    isOver = false;
                }
            }
        }

        if (isXwin() || isOwin()) {
            isOver = true;
        }

        return isOver;
    }

    /**
     * Helper method to check whether the computer wins.
     *
     * @return boolean whether X wins.
     */
    public boolean isXwin() {
        boolean iswin = false;

        if (board[0][0] != null && board[0][1] != null && board[0][2] != null) {
            if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
                iswin = true;
            }
        }

        if (board[1][0] != null && board[1][1] != null && board[1][2] != null) {
            if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
                iswin = true;
            }
        }

        if (board[2][0] != null && board[2][1] != null && board[2][2] != null) {
            if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
                iswin = true;
            }
        }

        if (board[0][0] != null && board[1][0] != null && board[2][0] != null) {
            if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
                iswin = true;
            }
        }

        if (board[0][1] != null && board[1][1] != null && board[2][1] != null) {
            if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) {
                iswin = true;
            }
        }

        if (board[0][2] != null && board[1][2] != null && board[2][2] != null) {
            if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
                iswin = true;
            }
        }

        if (board[0][0] != null && board[1][1] != null && board[2][2] != null) {
            if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
                iswin = true;
            }
        }

        if (board[0][2] != null && board[1][1] != null && board[2][0] != null) {
            if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
                iswin = true;
            }
        }

        return iswin;
    }

    /**
     * Helper method to check whether the player wins.
     *
     * @return boolean whether O wins
     */
    public boolean isOwin() {
        boolean iswin = false;

        if (board[0][0] != null && board[0][1] != null && board[0][2] != null) {
            if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
                iswin = true;
            }
        }

        if (board[1][0] != null && board[1][1] != null && board[1][2] != null) {
            if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
                iswin = true;
            }
        }

        if (board[2][0] != null && board[2][1] != null && board[2][2] != null) {
            if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
                iswin = true;
            }
        }

        if (board[0][0] != null && board[1][0] != null && board[2][0] != null) {
            if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
                iswin = true;
            }
        }

        if (board[0][1] != null && board[1][1] != null && board[2][1] != null) {
            if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) {
                iswin = true;
            }
        }

        if (board[0][2] != null && board[1][2] != null && board[2][2] != null) {
            if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
                iswin = true;
            }
        }

        if (board[0][0] != null && board[1][1] != null && board[2][2] != null) {
            if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
                iswin = true;
            }
        }

        if (board[0][2] != null && board[1][1] != null && board[2][0] != null) {
            if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
                iswin = true;
            }
        }

        return iswin;
    }

    /**
     * Returns the value of an end-game state. Throws a new IllegalStateException if the
     * current state is not an end-game.
     *
     * @return 1 for a win for X, -1 for a loss.
     */
    public int getValue() {
        if (!gameOver()) {
            throw new IllegalStateException();
        }

        int val = 0;

        if (isXwin()) {
            val = 1;
        }

        if (isOwin()) {
            val = -1;
        }
        return val;
    }

    /**
     * Tests whether a move is legal and performs it if so.
     *
     * @param m Move The move to be done.
     * @return true if move was legal, false otherwise.
     */
    public boolean doMove(State.Move m) {
        TicTacToeState.Move newm = (TicTacToeState.Move) m;
        boolean isValid = false;

        if (newm.r < 3 && newm.c < 3 && board[newm.r][newm.c] == null) {
            if (playerTurn) {
                board[newm.r][newm.c] = "O";
                playerTurn = false;
            } else {
                board[newm.r][newm.c] = "X";
                playerTurn = true;
            }
            isValid = true;
        }

        return isValid;
    }

    /**
     * Undoes the effects of the given move.
     *
     * @param m Move The move to be undone.
     */
    public void undoMove(State.Move m) {
        TicTacToeState.Move newm = (TicTacToeState.Move) m;
        if (newm.r < 3 && newm.c < 3) {
            board[newm.r][newm.c] = null;
        }
    }

    public class Move implements State.Move {

        int r;
        int c;

        /**
         * Default constructor.
         */
        public Move( int r, int c ){
            this.r = r;
            this.c = c;
        }

        /**
         * Returns a string representation of this move.
         *
         * @return The string representing this move.
         */
        public String toString(){
            return "row " + r + " column " + c;
        }

        /**
         * Determine whether this move is equal to another object.
         *
         * @return true if all data from the move matches, false otherwise.
         */
        public boolean equals( Object o ){
            if( o instanceof Move ){
                Move m = (Move)o;

                return m.r==r && m.c==c;
            }

            return false;
        }

    }
}
