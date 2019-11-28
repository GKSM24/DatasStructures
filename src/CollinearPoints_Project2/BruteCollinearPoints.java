package CollinearPoints_Project2;
import java.util.ArrayList;
import java.util.Collections;

public class BruteCollinearPoints {
    Point[] points;
    int no_of_segments;
    public BruteCollinearPoints(Point[] points){  // finds all line segments containing 4 points
        if(points == null)
            throw new IllegalArgumentException("Arrays cannot be null.");
        this.points = points;
        no_of_segments = 0;
    }
    public int numberOfSegments(){   // the number of line segments
        return no_of_segments;
    }
    public LineSegment[] segments(){
        ArrayList<LineSegment> temp = new ArrayList<>();
        for(Point p:points) {
            System.out.println(p);
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
                if(!isXPresent(temp, point_list.get(0))) {
                    temp.add(new LineSegment(point_list.get(0), point_list.get(point_list.size() - 1)));
                    no_of_segments++;
                }
            }
            point_list.clear();
        }
        LineSegment arr[] = new LineSegment[temp.size()];
        for(int index = 0; index < temp.size(); index++)
            arr[index] = temp.get(index);
        return arr;
    }

    private boolean isXPresent(ArrayList<LineSegment> arr, Point x){
        for(LineSegment l:arr)
            if(l.getP().compareTo(x)==0)
                return true;
        return false;
    }
    public static void main(String args[]) throws Exception{
        Point p1 = new Point(18000,      10000);
        Point p2 = new Point(19000,  10000);
        Point p3 = new Point(32000,   10000);
        Point p4 = new Point(1234 ,  5678);
        Point p5 = new Point(21000 , 10000);
        Point p6 = new Point(14000, 10000);
        /*Point p1 = new Point(10000,      0);
        Point p2 = new Point(0,  10000);
        Point p3 = new Point(3000,   7000);
        Point p4 = new Point(7000 ,  3000);
        Point p5 = new Point(20000 , 21000);
        Point p6 = new Point(6000 ,  7000);
        Point p7 = new Point(3000,   4000);
        Point p8 = new Point(14000, 15000);*/
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        Point points[] = {p1,p2,p3,p4,p5,p6};
        for(Point p:points)
            p.draw();
        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        for(LineSegment line:bcp.segments()) {
            line.draw();
            System.out.println(line);
        }
        System.out.println(bcp.numberOfSegments());
    }
}
