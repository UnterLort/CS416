/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class CrawlBot implements Robot {
    private int x;
    private int y;
    private int d;

    /**
     * 
     * Sets the x, y, and direction to 0.
     */
    public CrawlBot() {
        this.x = 0;
        this.y = 0;
        this.d = 0;
    }

    /**
     * 
     * @param x x intercept
     * @param y y intercept
     * @param d direction
     */
    public CrawlBot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d % 360;
    }

    /**
     * 
     * @return x value
     */
    public int getX() {
        return this.x;
    }

    /**
     * 
     * @return y value
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @return value of the direction
     */
    public int getDirection() {
        return this.d;
    }

    /**
     * 
     * Turns crawlbot 90 degrees right.
     */
    public void turnRight() {
        this.d = (this.d + 270) % 360;
    }

    /**
     * 
     * Turns crawl bot 90 degrees left.
     */
    public void turnLeft() {
        this.d = (this.d + 90) % 360;
    }

    /**
     * 
     * @param dist distance
     */
    public void moveForward(int dist) {
        if (this.d == 0) {
            this.x += dist;
        } else if (this.d == 90) {
            this.y += dist;
        } else if (this.d == 180) {
            this.x -= dist;
        } else if (this.d == 270) {
            this.y -= dist;
        }
    }

    /**
     * 
     * @param dist distance
     */
    public void moveBackward(int dist) {
        if (this.d == 0) {
            this.x -= dist;
        } else if (this.d == 90) {
            this.y -= dist;
        } else if (this.d == 180) {
            this.x += dist;
        } else if (this.d == 270) {
            this.y += dist;
        }
    }

    @Override
    public String toString() {
        return "CrawlBot at (" + this.x + ", " + this.y + ") heading " + this.d + " degrees";
    }
}