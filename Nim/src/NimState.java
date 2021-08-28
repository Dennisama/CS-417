import java.util.ArrayList;

/**
 * This class represents a single state in a Nim game.
 *
 * @author Biao Zhang
 * @version 07/27/2020
 */
public class NimState implements State {
    /**
     * stacks int[] an array of integers to track how many objects remain
     *              in each stack.
     * pt boolean indicates whether the game should begin with the human player
     *            taking the first turn (true) or the computer taking the first
     *            turn (false.)
     */
    private int[] stacks;
    private boolean pt;

    /**
     * The main constructor for NimState.
     *
     * @param n the number of stacks
     * @param pt the player's turn or not
     */
    public NimState(int n, boolean pt) {
        stacks = new int[n];
        //Array starts at 0, but stack numbers in
        //Move start at 1.
        for (int i = 0; i < n; i++) {
            stacks[i] = i + 1;
        }

        this.pt = pt;
    }

    /**
     * A copy constructor for NimState.
     *
     * @param stacks the state array
     * @param pt the player's turn or not
     */
    public NimState(int[] stacks, boolean pt) {
        int[] copystacks = new int[stacks.length];
        for (int i = 0; i < stacks.length; i++) {
            copystacks[i] = stacks[i];
        }

        this.stacks = copystacks;
        this.pt = pt;
    }

    /**
     * Returns the stacks array for this state.
     *
     * @return int[] the number of items in each stack
     */
    public int[] getStacks() {
        return stacks;
    }

    /**
     * Returns a string representation of this game state,
     * displaying a label for each stack and an X for each
     * item in it.
     *
     * @return String
     */
    public String toString() {

        if (stacks.length == 0) {
            return "";
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < stacks.length; i++) {
            ret.append(i + 1).append(":").append(" ");
            int num = stacks[i];
            while (num != 0) {
                ret.append("X");
                num--;
            }
            ret.append("\n");
        }

        return ret.toString();
    }

    /**
     * Finds all valid moves from the current state.
     *
     * @return ArrayList of moves.
     */
    @Override
    public ArrayList<State.Move> findAllMoves() {
        ArrayList<State.Move> allmoves = new ArrayList<State.Move>();

        for (int i = 0; i < stacks.length; i++) {
            int num = stacks[i];
            // Number of items taken from a given stack
            // is between 1 and 3.
            if (num >= 3) {
                Move newmove3 = new Move(i + 1, 3);
                allmoves.add(newmove3);

                Move newmove2 = new Move(i + 1, 2);
                allmoves.add(newmove2);

                Move newmove1 = new Move(i + 1, 1);
                allmoves.add(newmove1);

            } else if (num >= 2) {
                Move newmove2 = new Move(i + 1, 2);
                allmoves.add(newmove2);

                Move newmove1 = new Move(i + 1, 1);
                allmoves.add(newmove1);

            } else if (num >= 1) {
                Move newmove1 = new Move(i + 1, 1);
                allmoves.add(newmove1);

            }

        }

        return allmoves;
    }

    /**
     * Tests whether the game is over.
     *
     * @return true if game is over, false otherwise.
     */
    @Override
    public boolean gameOver() {
        boolean isover = true;
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i] != 0) {
                isover = false;
            }
        }
        return isover;
    }

    /**
     * Returns the value of an end-game state. Throws an exception if the
     * current state is not an end-game.
     *
     * @return 1 for a win, -1 for a loss.
     */
    @Override
    public int getValue() {
        if (!gameOver()) {
            throw new IllegalStateException();
        }

        int res = 0;

        // The turn changes after the move
        if (pt) {
            // If Game is over, and the state begins with player's turn,
            // it indicates the computer is in the last turn. Therefore,
            // player wins.
            // -1 for computer's loss
            res = -1;
        } else {
            // 1 for computer's win
            res = 1;
        }

        // The GameTree's nodes will be able to assign values to nodes which
        // do not represent end of games using the minimax algorithm, but
        // you cannot do that in this method.

        return res;
    }

    /**
     * Returns whether it is the human player's turn or not.
     *
     * @return true if it is the human player's turn.
     */
    @Override
    public boolean isPlayerTurn() {
        return pt;
    }

    /**
     * Tests whether a move is valid and performs it if so.
     *
     * @param move Move The move to be done.
     * @return true if move was valid, false otherwise.
     */
    @Override
    public boolean doMove(State.Move move) {
        boolean isvalid = false;
        Move newmove = (NimState.Move) move;
        int indexofstacks = newmove.stack - 1;

        if (indexofstacks >= 0 && indexofstacks < stacks.length) {
            if (stacks[indexofstacks] >= newmove.num) {
                stacks[indexofstacks] -= newmove.num;
                pt = !pt;
                isvalid = true;
            }
        }

        return isvalid;
    }

    /**
     * Undoes the effects of the given move.
     *
     * @param move Move The move to be undone.
     */
    @Override
    public void undoMove(State.Move move) {
        Move newmove = (NimState.Move) move;
        int indexofstacks = newmove.stack - 1;
        stacks[indexofstacks] += newmove.num;
        pt = !pt;
    }

    /**
     * This class represents a single move in a Nim game.
     */
    public static class Move implements State.Move {

        /**
         * All attributes.
         */
        private int stack;
        private int num;

        /**
         * The default constructor.
         *
         * @param stack int an integer indicating which stack to take items from.
         * @param num int an integer indicating how many items to take.
         */
        public Move(int stack, int num) {
            //Stack numbers start at 1 for the first stack, not zero.
            this.stack = stack;
            this.num = num;
        }

        /**
         * Compares an object o to this move.
         *
         * @param o Object
         * @return boolean Returns true if o is a Move and takes the same number
         *         of items from the same stack as this move.
         */
        public boolean equals(Object o) {
            if (o instanceof Move) {
                Move comp = (Move) o;
                return comp.stack == stack && comp.num == num;
            }

            return false;
        }

        /**
         * Show the string representation.
         *
         * @return String the string representation.
         */
        public String toString() {
            String ret = "";
            ret = "Taking " + num + " from stack " + stack;
            return ret;
        }
    }
}
