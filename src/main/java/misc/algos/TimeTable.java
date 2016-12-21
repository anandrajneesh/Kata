package misc.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anand_rajneesh on 12/7/2016.
 */
public class TimeTable {

    private static double MAXDURATION = 3.0;
    private static boolean RED = true;
    private static boolean BLACK = false;

    private static class Activity{
        private String name;
        private double duration;

        public Activity(String name, double duration) {
            this.name = name;
            //convert minutes to hours
            if(duration >= 10){
                duration = duration/60d;
            }
            this.duration = duration;
        }
    }

    private static class ActivityGroup implements Comparable<ActivityGroup>{
        private List<Activity> activities = new ArrayList<>();
        private int rank = 0;
        private double diff = MAXDURATION;

        @Override
        public int compareTo(ActivityGroup o) {
            if(this.rank == o.rank){
                return Double.compare(o.diff, this.diff);
            }
            else {
                return (this.rank - o.rank);
            }
        }

        public void addActivity(Activity e){
            activities.add(e);
            rank++;
            diff-=e.duration;
        }

        public int compareTo(Activity e){
            return Double.compare(diff, e.duration);
        }
    }

    private static class Node{
        private ActivityGroup key;
        private Node left;
        private Node right;
        private boolean color;

        public Node(ActivityGroup key) {
            this.key = key;
            color = RED;
        }
    }

    private Node root;
    private List<ActivityGroup> groups = new ArrayList<>();

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }

    public void add(Activity activity){
        root = add(root, activity);
        root.color = BLACK;
    }

    public Node add(Node x, Activity activity){
        if (x == null){
            ActivityGroup group = new ActivityGroup();
            group.addActivity(activity);
            return new Node(group);
        }
        int diff = x.key.compareTo(activity);
        //new activity duration is longer than what group can hold
        if (diff < 0) {
          //  x.right = put(x.right, activity);
            //new activity duration can be accommodated by group
        } else if (diff > 0) {
            x.key.addActivity(activity);
            //FIXME duration and diff are same pop this group from tree
        } else {
            x.key.addActivity(activity);
            groups.add(x.key);
        }

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.right) && isRed(x.left)) flipColors(x);
        return x;
    }

    private boolean isRed(Node x){
        return x != null && x.color;
    }

    private Node put(Node node, ActivityGroup key) {
        if (node == null) return new Node(key);
        int diff = node.key.compareTo(key);
        if (diff < 0) {
            node.right = put(node.right, key);
        } else if (diff > 0) {
            node.left = put(node.left, key);
        } else {
            //   node.value = value;
        }
        return node;
    }

}
