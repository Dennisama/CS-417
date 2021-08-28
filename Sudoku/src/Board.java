import java.util.Scanner;

/**
 * This class represents the 9x9 board of values for the Sudoku puzzle.
 *
 * @author Biao Zhang
 * @version 1.0
 */
public class Board {

    /**
     * Attributes.
     */
    private static int[][] originalboard;
    private int[][] board;


    /**
     * Constructor for the Board class.
     *
     * @param sc scanner to read the inputs.
     */
    public Board(Scanner sc) {
        //Where to read the file ?
        board = readBoard(sc);
    }

    /**
     * Uses the provided Scanner to read the board and
     * return a 2D integer array with the appropriate values.
     *
     * @param sc scanner to read the inputs
     * @return 2d array
     */
    public static int[][] readBoard(Scanner sc) {

        String[] input = new String[9];
        for (int i = 0; i < 9; i++) {
            input[i] = sc.nextLine();
        }

        originalboard = new int[9][9];
        int[][] newboard = new int[9][9];

        for (int i = 0; i < 9; i++) {
            if (input[i].length() == 9) {
                for (int j = 0; j < 9; j++) {
                    if (input[i].charAt(j) == '-') {
                        newboard[i][j] = 0;
                        originalboard[i][j] = 0;
                    } else if (Character.isDigit(input[i].charAt(j))) {
                        int val = Character.getNumericValue(input[i].charAt(j));
                        newboard[i][j] = val;
                        originalboard[i][j] = val;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        }

        return newboard;
    }

    /**
     * Returns the value at row, col in the board.
     *
     * @param row the row.th row
     * @param col the col.th column
     * @return return the value in the board
     */
    public int get(int row, int col) {
        //Here we do not check whether the input is valid
        return board[row][col];
    }

    /**
     * Sets the value at row, col in the board.
     *
     * @param row the row.th row
     * @param col the col.th column
     * @param value set the value in the board
     */
    public void set(int row, int col, int value) {
        //Does not need to confirm that the value is allowed,
        //as these checks should be done before calling this method.
        board[row][col] = value;
    }

    /**
     * Returns true if number was already contained in row,
     * false otherwise.
     *
     * @param row the row.th row
     * @param number the value to put in the board
     * @return whether it is contained
     */
    public boolean containsInRow(int row, int number) {

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if number was already contained in col,
     * false otherwise.
     *
     * @param col the col.th column
     * @param number the value to put in the board
     * @return whether it is contained
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
     * Returns true if number was already contained in
     * the 3x3 box containing row, col, false otherwise.
     *
     * @param row the row.th row
     * @param col the col.th column
     * @param number the value to put in the board
     * @return whether it is in 3X3 box
     */
    public boolean containsInBox(int row, int col, int number) {
        int rowbox = row / 3;
        int colbox = col / 3;

        for (int i = rowbox * 3; i <= (rowbox * 3 + 2); i++) {
            for (int j = colbox * 3; j <= (colbox * 3 + 2); j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if number would be valid to assign
     * to row, col, false otherwise.
     *
     * @param row the row.th row
     * @param col the col.th column
     * @param number the value to put in the board
     * @return whether it is allowed
     */
    public boolean isAllowed(int row, int col, int number) {
        if (!containsInRow(row, number) && !containsInCol(col, number)
                && !containsInBox(row, col, number) && originalboard[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the board.
     *
     * @return the string representation
     */
    public String toString() {
        char element;
        StringBuilder res = new StringBuilder("+-------+-------+-------+\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == 0) {
                    element = '-';
                } else {
                    element = Character.forDigit(board[i][j], 10);
                }

                if (j == 0) {
                    res.append("| ").append(element);
                } else if (j % 3 == 2) {

                    res.append(" ").append(element).append(" |");

                    if (j == 8) {
                        res.append("\n");
                        if (i % 3 == 2) {
                            if (i == 8) {
                                res.append("+-------+-------+-------+");
                            } else {
                                res.append("+-------+-------+-------+\n");
                            }

                        }
                    }
                } else {
                    res.append(" ").append(element);
                }

            }
        }

        return res.toString();
    }

}
