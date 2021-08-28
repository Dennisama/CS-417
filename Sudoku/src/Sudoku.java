import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class does the work of solving the Sudoku puzzle,
 * as well as containing the main method to provide a
 * text-based user interface.
 *
 * @author Biao Zhang
 * @version 1.0
 */
public class Sudoku {

    /**
     * All attributes.
     */
    private Board boardinfo;
    private int reccount = 0;
    private int backcount = 0;

    /**
     * Constructor for the Sudoku class.
     *
     * @param sc the scanner to read inputs
     */
    public Sudoku(Scanner sc) {
        boardinfo = new Board(sc);
    }

    /**
     * Recursively solves the board from the current configuration.
     *
     * @param loc the location object
     * @return whether it is solved
     */
    public boolean solve(Location loc) {
        reccount += 1;

        if (loc == null) {
            return true;
        } else if (boardinfo.get(loc.getRow(), loc.getColumn()) != 0) {
            return solve(loc.next());
        } else {

            for (int i = 1; i < 10; i++) {
                if (boardinfo.isAllowed(loc.getRow(), loc.getColumn(), i)) {
                    boardinfo.set(loc.getRow(), loc.getColumn(), i);
                    if (solve(loc.next())) {
                        return true;
                    }
                }
            }

            backcount += 1;
            boardinfo.set(loc.getRow(), loc.getColumn(), 0);
            return false;
        }
    }

    /**
     * Returns the recursion count after the puzzle
     * has been solved.
     *
     * @return the counts of recursions.
     */
    public int getRecursionCount() {
        return reccount;
    }

    /**
     * Returns the backup count after the puzzle
     * has been solved.
     *
     * @return the counts of backups
     */
    public int getBackupCount() {
        return backcount;
    }

    /**
     * Returns the Sudoku board.
     *
     * @return the Board object
     */
    public Board getBoard() {
        return boardinfo;
    }

    /**
     * Testing codes.
     *
     * @param args no use
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path to the sudoku file:");
        String filename = input.nextLine();

        File file = new File(filename);

        try {

            Scanner boardScanner = new Scanner(file);

            // Sudoku creation and solving go here
            Sudoku mysudoku = new Sudoku(boardScanner);
            Location myloc = new Location(0, 0);

            System.out.println("Initial configuration of the sudoku");
            System.out.println(mysudoku.getBoard().toString());
            if (mysudoku.solve(myloc)) {
                System.out.println("Successful!");
                System.out.println("Final configuration of the sudoku");
                System.out.println(mysudoku.getBoard().toString());
                System.out.println("Recursion count = " + mysudoku.getRecursionCount());
                System.out.println("Backup count = " + mysudoku.getBackupCount());
            } else {
                System.out.println("Failed!");
                System.out.println(mysudoku.getBoard().toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }

    }
}
