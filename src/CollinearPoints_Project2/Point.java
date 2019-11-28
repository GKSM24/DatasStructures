package CollinearPoints_Project2;
import java.util.*;

/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;

public final class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */


    public Point(int x, int y) {
        /* DO NOT MODIFY */
        if(x>=0 && x<=32767 && y>=0 && y<=32767) {
            this.x = x;
            this.y = y;
        }
        else{
            this.x=0;
            this.y=0;
        }
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.setPenRadius(0.02);
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.setPenRadius(0.005);
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        if(this.x == that.x && this.y == that.y)
            return Double.NEGATIVE_INFINITY;
        else if(this.x == that.x)
            return Double.POSITIVE_INFINITY;
        else if(this.y == that.y)
            return +0.0;
        else
            return ((double)(that.y-this.y)/(that.x - this.x));
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        double result = this.y - that.y;
        if(result < 0)
            return -1;
        else if(result == 0)
            return this.x - that.x;
        else
            return 1;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        Point current = this;
        return new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if(current.slopeTo(p1) < current.slopeTo(p2))
                    return -1;
                else if(current.slopeTo(p1) == current.slopeTo(p2))
                    return 0;
                else
                    return 1;
            }
        };
    }


    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        Point p1 = new Point(10000,      0);
        Point p2 = new Point(0,  10000);
        Point p3 = new Point(3000,   7000);
        Point p4 = new Point(7000 ,  3000);
        Point p5 = new Point(20000 , 21000);
        Point p6 = new Point(6000 ,  7000);
        Point p7 = new Point(3000,   4000);
        Point p8 = new Point(14000, 15000);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        //p1.draw();
        //p2.draw();
        //p3.draw();
        //p4.draw();
        //p4.drawTo(p3);
        //p2.drawTo(p3);
        Point points[] = {p1,p2,p3,p4,p5,p6,p7,p8};
        Arrays.sort(points);
        for(Point point:points) {
            point.draw();
            System.out.println(point);
        }
        for(int i = 0; i < points.length - 1; i++) {
            ArrayList<Point> point_list = new ArrayList<>();
            double slope = points[i].slopeTo(points[i+1]);
            point_list.add(points[i]);
            for (int j = 0; j < points.length; j++) {
                if (slope == points[i].slopeTo(points[j]) && !point_list.contains(points[j]))
                    point_list.add(points[j]);
            }
            if(point_list.size() >= 4) {
                Collections.sort(point_list);
                new LineSegment(point_list.get(0), point_list.get(point_list.size() - 1)).draw();
            }
            point_list.clear();
        }
        p1 = new Point(18000,      10000);
        p2 = new Point(19000,  10000);
        p3 = new Point(32000,   10000);
        p4 = new Point(1234 ,  5678);
        p5 = new Point(21000 , 10000);
        p6 = new Point(14000, 10000);
        Arrays.sort(points, new Point(0,0).slopeOrder());
        Point points1[] = {p1,p2,p3,p4,p5,p6};

    }
}
