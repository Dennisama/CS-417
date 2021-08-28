/**
 * This class represents a location on a Sudoku board.
 *
 * @author Biao Zhang
 * @version 1.0
 */
public class Location {
    /**
     * All attributes.
     */
    private int r;
    private int c;

    /**
     * The constructor for Location.
     *
     * @param r the r.th row
     * @param c the c.th column
     */
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    /**
     * Returns the Location's row value.
     *
     * @return r the r.th row
     */
    public int getRow() {
        return r;
    }

    /**
     * Returns the Location's column value.
     *
     * @return c the c.th column
     */
    public int getColumn() {
        return c;
    }

    /**
     * Gets the next Location after this one.
     *
     * @return Location the object.
     */
    public Location next() {
        Location newloc = new Location(r, c);
        if (newloc.c == 8) {
            newloc.c = 0;
            newloc.r += 1;
        } else {
            newloc.c += 1;
        }

        if (newloc.r < 9 && newloc.r >= 0 && newloc.c < 9 && newloc.c >= 0) {
            return newloc;
        }

        return null;
    }

    /**
     * Returns a string representation of this Location.
     *
     * @return the string representation.
     */
    public String toString() {
        return r + ", " + c;
    }
}
