/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Point {

    private double x;
    private double y;

    /**
     * 
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @param p the other point to compare with.
     * @return a new Point with the maximum x and y coordinates.
     */
    public Point max(Point p) {
        return new Point(Math.max(this.x, p.x), Math.max(this.y, p.y));
    }

    /**
     * 
     * @return a string representation of the point.
     */
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

}