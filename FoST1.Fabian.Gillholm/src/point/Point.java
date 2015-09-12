package point;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean isEqualTo(Point other) {
        return this.x == other.x && this.y == other.y;
    }

    public double distanceTo(Point other) {
        // http://www.mathwarehouse.com/algebra/distance_formula/index.php
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public String move(int x, int y) {
        this.x += x;
        this.y += y;
        return this.toString();
    }

    public String moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
        return this.toString();
    }
}
