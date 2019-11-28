package CollinearPoints_Project2;
import java.util.Arrays;

public class FastCollinearPoints {
    Point[] points;
    int no_of_segments;
    public FastCollinearPoints(Point[] points){  // finds all line segments containing 4 points
        this.points = points;
        no_of_segments = 0;
    }
    public int numberOfSegments(){   // the number of line segments
        return no_of_segments;
    }
    public LineSegment[] segments() {
        LineSegment[] temp = new LineSegment[1];

        for(int p_index = 0; p_index < points.length-3; p_index++) {
            Arrays.sort(points, points[p_index].slopeOrder());
            for(Point p:points) {
                System.out.println(p);
            }
            Point p = points[p_index], q = points[p_index+1], r = points[p_index+2],s = points[p_index+3];
            if(p.slopeTo(q)==p.slopeTo(r) && p.slopeTo(r)==p.slopeTo(s)){
                Point max = p, min = p;
                int t_index = p_index+4;
                for(; t_index < points.length && p.slopeTo(s)==p.slopeTo(points[t_index]); t_index++){}
                for(int index = p_index+1; index < t_index; index++) {
                    if(min.compareTo(points[index]) > 0)
                        min = points[index];
                    if(max.compareTo(points[index]) < 0)
                        max = points[index];
                }
                if(!isXPresent(temp, min)) {
                    if (temp[temp.length - 1] != null)
                        temp = Arrays.copyOf(temp, temp.length + 1);
                    temp[temp.length - 1] = new LineSegment(min, max);
                    temp[temp.length - 1].draw();
                    no_of_segments++;
                }
            }
        }
        return temp;
    }

    private boolean isXPresent(LineSegment[] arr, Point x){
        for (LineSegment l : arr)
            if (l != null && l.getP().compareTo(x) == 0)
                return true;
        return false;
    }

    public static void main(String[] args){
        /*Point p1 = new Point(10000,      0);
        Point p2 = new Point(0,  10000);
        Point p3 = new Point(3000,   7000);
        Point p4 = new Point(7000 ,  3000);
        Point p5 = new Point(20000 , 21000);
        Point p6 = new Point(6000 ,  7000);
        Point p7 = new Point(3000,   4000);
        Point p8 = new Point(14000, 15000);*/
        Point p1 = new Point(18000,      10000);
        Point p2 = new Point(19000,  10000);
        Point p3 = new Point(32000,   10000);
        Point p4 = new Point(1234 ,  5678);
        Point p5 = new Point(21000 , 10000);
        Point p6 = new Point(14000, 10000);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        Point points[] = {p1,p2,p3,p4,p5,p6};
        for(Point p:points)
            p.draw();
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        for(LineSegment line:fcp.segments())
            System.out.println(line);
        System.out.println(fcp.numberOfSegments());
    }
}
