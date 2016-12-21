package coursera.algorithms.week3;

import java.util.Arrays;

/**
 * Created by Anand_Rajneesh on 10/14/2016.
 */
public class FastCollinearPoints1 {
    private LineSegment[] lineSegments;

    public FastCollinearPoints1(Point[] points) {

        checkNull(points);
        checkDuplicate(points);

        Point[] aux = getCopy(points);
        ResizingSet<Line> lines = new ResizingSet<>(points.length/2);

        for (Point p : points) {//n
            Arrays.sort(aux, p.slopeOrder());
            for (int i = 1; i < aux.length - 1; ) {//n
                Point p1 = aux[i];
                double slope = p.slopeTo(p1);
                int potentialPointer = 0;
                Point[] potentialPoints = new Point[points.length];
                potentialPoints[potentialPointer++] = p1;
                for (int j = i + 1; j < aux.length; j++) {
                    i = j;
                    Point next = aux[j];
                    if (slope == p.slopeTo(next)) {
                        potentialPoints[potentialPointer++] = next;
                    } else {
                        break;
                    }
                }
                if (potentialPoints[2] != null) {//atleast 4 points for line segment
                    Point[] minMaxPoints = getMinMaxPoints(potentialPoints, p, potentialPointer);
                    Line line = new Line(minMaxPoints[0], minMaxPoints[1]);
                    lines.add(line);
                }
            }
        }
        lineSegments = trimLineSegments(lines);
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

    private Point[] getMinMaxPoints(Point[] points, Point p4, int size) {
        Point pointMinForLine = p4;
        Point pointMaxForLine = p4;

        for (int x = 0; x < size; x++) {
            Point t = points[x];
            if (pointMinForLine.compareTo(t) > 0) {
                pointMinForLine = t;
            }
            if (pointMaxForLine.compareTo(t) < 0) {
                pointMaxForLine = t;
            }
        }
        return new Point[]{pointMinForLine, pointMaxForLine};
    }

    private LineSegment[] trimLineSegments(ResizingSet<? extends Line> lines) {
        LineSegment[] tmp = new LineSegment[lines.size()];
        for(int i=0; i<lines.size(); i++){
            Line line = lines.get(i);
            tmp[i] = new LineSegment(line.minPoint,line.maxPoint);
        }
        return tmp;
    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int j = 0; j < points.length && j != i; j++) {
                Point p2 = points[j];
                if (p1.compareTo(p2) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void checkNull(Point[] points) {
        for (Point p : points) {
            if (p == null) throw null;
        }
    }

    private Point[] getCopy(Point[] points) {
        Point[] tmp = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            tmp[i] = points[i];
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


    private static class Line{

        private Point minPoint;
        private Point maxPoint;

        private Line(Point minPoint, Point maxPoint) {
            this.minPoint = minPoint;
            this.maxPoint = maxPoint;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Line) {
                Line otherLine = (Line) obj;
                if(otherLine.maxPoint == maxPoint && otherLine.minPoint == minPoint){
                    return true;
                }
            }
            return false;
        }
    }

    private static class ResizingSet<T>{

        private Object[] items;
        private int size;

        private ResizingSet(int n){
            items = new Object[n];
        }

        private void add(T item){
            if(exists(item)) return;
            checkCapacityAndIncrement();
            items[size++] = item;
        }

        private boolean exists(T item) {
            for(Object o : items){
                if(item.equals(o)){
                    return true;
                }
            }
            return false;
        }

        private void checkCapacityAndIncrement(){
            if(items.length==size){
                Object[] tmp = new Object[size*2];
                for(int i =0;i<size;i++){
                    tmp[i] = items[i];
                }
                items = tmp;
            }
        }

        private int size(){
            return size;
        }


        private T get(int index){
            return (T) items[index];
        }



    }
}
