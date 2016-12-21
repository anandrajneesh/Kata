package coursera.algorithms.week3;

/**
 * Created by Anand_Rajneesh on 10/14/2016.
 */
public class BruteCollinearPoints {
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        checkNull(points);
        checkDuplicate(points);

        int actualLineSegmentLength = 0;
        lineSegments = new LineSegment[points.length];
        Point[] pointsAdded = new Point[points.length];
        int nextPointer = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(j == i) continue;
                for (int k = 0; k < points.length; k++) {
                    if((k == j || k == i)) continue;
                    Point p1 = points[i];
                    Point p2 = points[j];
                    double slopeP2 = p1.slopeTo(p2);
                    Point p3 = points[k];
                    if (slopeP2 != p1.slopeTo(p3)) continue;
                    for (int l = 0; l < points.length; l++) {
                        if(!(l != k && l != j && l != i))continue;
                        Point p4 = points[l];
                        if(p1.slopeTo(p4) == slopeP2){
                            Point[] minMaxPoints =  getMinMaxPoints(p1,p2,p3,p4);
                            if(!contains(pointsAdded, minMaxPoints)){
                                lineSegments[actualLineSegmentLength++] = new LineSegment(minMaxPoints[0], minMaxPoints[1]);
                                pointsAdded[nextPointer++] = minMaxPoints[0];
                                pointsAdded[nextPointer++] = minMaxPoints[1];
                            }
                        }
                    }
                }
            }
        }
        lineSegments = trimLineSegments(lineSegments,actualLineSegmentLength);
    }

    private boolean contains(Point[] set, Point[] tmp){
        boolean contains = false;
        if(set.length ==0) return false;
        for(int i=0; i<set.length;i=i+2){
            if(set[i]==null) break;
            if(set[i].equals(tmp[0])){
                if(set[i+1].equals(tmp[1])){
                    contains= true;
                }
            }
        }
        return contains;
    }

    private Point[] getMinMaxPoints(Point p1, Point p2, Point p3, Point p4){
        Point pointMinForLine = p1;
        Point pointMaxForLine = p1;

        Point[] collinearPoints = new Point[3];
        collinearPoints[0] = p2;
        collinearPoints[1] = p3;
        collinearPoints[2] = p4;

        for(int x = 0;x<collinearPoints.length; x++){
            Point t = collinearPoints[x];
            if(pointMinForLine.compareTo(t) > 0){
                pointMinForLine = t;
            }
            if(pointMaxForLine.compareTo(t) < 0){
                pointMaxForLine = t;
            }
        }
        return new Point[]{pointMinForLine,pointMaxForLine};
    }

    private LineSegment[] trimLineSegments(LineSegment[] segments, int actualSize){
        LineSegment [] tmp = new LineSegment[actualSize];
        while(--actualSize >= 0){
            tmp[actualSize] = segments[actualSize];
        }
        return tmp;
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        LineSegment[] array = new LineSegment[lineSegments.length];
        for(int i =0; i<lineSegments.length;i++){
            array[i] = lineSegments[i];
        }
        return array;
    }

    private void checkDuplicate(Point[] points){
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int j = 0; j < points.length && j != i; j++) {
                Point p2 = points[j];
                if(p1.compareTo(p2) == 0){
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void checkNull(Point[] points){
        for (Point p : points) {
            if (p == null) throw null;
        }
    }
}