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


public class KdTree {

    private static class Node{
        private Point2D point;
        private Node left;
        private Node right;

        public Node(Point2D point) {
            this.point = point;
        }
    }

    private static int dimension = 2;
    private Node root;
    private int size;

    private TreeSet<Point2D> points;

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return root == null;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        root = insert(root, p ,0);
    }

    private Node insert(Node x, Point2D p, int level) {
        if (x == null) return new Node(p);
        if (less(x.point, p, level++)) {
            x.left = insert(x.left, p, level);
        } else {
            x.right = insert(x.right, p, level);
        }
        return x;
    }

    private boolean less(Point2D p1, Point2D p2, int level){
        return level % dimension == 0 ? isPointOnLeft(p1, p2) : isPointBelow(p1, p2);
    }

    private boolean isPointOnLeft(Point2D p, Point2D p1){
        return p.x() > p1.x();
    }

    private boolean isPointBelow(Point2D p, Point2D p1){
        return p.y() > p1.y();
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return contains(root, p, 0) != null;
    }

    private Node contains(Node x, Point2D p, int level){
        if(x == null) return null;
        if(x.point.equals(p)){
            return x;
        }else if(less(x.point, p, level++)){
            return contains(x.left, p, level);
        }else{
            return contains(x.right, p ,level);
        }
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
   /* public Point2D nearest(Point2D p) {
       if(root == null) return null;

        Node x = root;
        Node smallest = root;
        while(x!=null){

        }

    }*/


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


