/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Location {
    private int row;
    private int col;

    /**
     * 
     * @param r row
     * @param c column
     */
    public Location(int r, int c) {
        row = r;
        col = c;
    }

    /**
     * 
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * 
     * @return column
     */
    public int getColumn() {
        return col;
    }

    /**
     * 
     * @return next location
     */
    public Location next() {
        if (col == 8) {
            if (row == 8) {
                return null;
            } else {
                return new Location(row + 1, 0);
            }
        } else {
            return new Location(row, col + 1);
        }
    }

    /**
     * 
     * @return string representation of location
     */
    public String toString() {
        return row + ", " + col;
    }
}