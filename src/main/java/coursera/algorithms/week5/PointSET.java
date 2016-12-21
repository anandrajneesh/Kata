package coursera.algorithms.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Anand_Rajneesh on 11/7/2016.
 */


public class PointSET {

    private TreeSet<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        points.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Iterator<Point2D> itr = points.iterator();
        List<Point2D> pointsInRect = new ArrayList<>();
        while(itr.hasNext()){
            Point2D p = itr.next();
            if(rect.contains(p)){
                pointsInRect.add(p);
            }
        }
        return pointsInRect;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (points.isEmpty()) {
            return null;
        }
        Point2D closestPoint = null;
        Iterator<Point2D> itr = points.iterator();
        for(;itr.hasNext(); closestPoint = closestToPoint(p,closestPoint,itr.next()));
        return closestPoint;
    }

    private Point2D closestToPoint(Point2D p, Point2D p1, Point2D p2){
        if(p1 == null || p2==null) return p1==null?p2:p1;
        if(p1.distanceSquaredTo(p) > p2.distanceSquaredTo(p)){
            return p2;
        }else{
            return p1;
        }
    }

    public static void main(String[] args) {
    }                 // unit testing of the methods (optional)
}


