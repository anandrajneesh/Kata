package coursera.algorithms.week4;

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 11/2/2016.
 */
public class BST<K extends Comparable<K>, V> {

    private class Node {

        private K key;
        private V value;
        private int count;
        private Node left, right;
        private int depth;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.depth = 1;
        }
    }

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value);
        int diff = node.key.compareTo(key);
        if (diff < 0) {
            node.right = put(node.right, key, value);
        } else if (diff > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        node.depth = 1 + (depth(node.left) > depth(node.right) ? depth(node.left) : depth(node.right));
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.count;
    }

    public V get(K key) {
        Node node = get(key, root);
        if (node != null) return node.value;
        return null;
    }

    private Node get(K key, Node x) {
        if (x == null) return null;
        int diff = x.key.compareTo(key);
        if (diff < 0) {
            return get(key, x.right);
        } else if (diff > 0) {
            return get(key, x.left);
        } else {
            return x;
        }
    }

    public K max() {
        Node x = root;
        K max = null;
        while (x != null) {
            max = x.key;
            x = x.right;
        }
        return max;
    }

    public K min() {
        K min = null;
        for (Node x = root; x != null; min = x.key, x = x.left) ;
        return min;
    }

    private Node min(Node x) {
        for (;x.left != null; x = x.left) ;
        return x;
    }

    public K floor(K key) {
        return floor(key, root);
    }

    public K floor(K key, Node x) {
        if (x == null) return null;
        int diff = x.key.compareTo(key);

        if (diff == 0) return key;
        if (diff > 0) return floor(key, x.left);

        K t = floor(key, x.right);
        if (t == null) return x.key;
        else return t;
    }

    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node x) {
        if (x == null) return 0;
        int diff = key.compareTo(x.key);
        if (diff == 0) return size(x.left);
        else if (diff > 0) return 1 + size(x.left) + rank(key, x.right);
        else return rank(key, x.left);
    }

    public Iterable<K> keys() {
        Queue<K> q = new Queue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<K> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.left == null) return x.right;
        x.left = delMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int diff = key.compareTo(x.key);
        if (diff > 0) x.right = delete(x.right, key);
        else if (diff < 0) x.left = delete(x.left, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            Node t = x;
            x = min(x.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        x.depth = 1 + (depth(x.left) > depth(x.right) ? depth(x.left) : depth(x.right));
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private int depth(Node x){
        if(x == null) return 0;
        return x.depth;
    }

    public int depth(K key){
        Node x = get(key, root);
        if(x == null) return 0;
        else return x.depth;
    }

    public int depth(){
        return depth(root);
    }

    public List<K> diameter(){
        List<K> list = new ArrayList<>();
        diameter(root, list);
        return list;
    }

    private void diameter(Node x, List<K> list){
        if(x == null) return;

        if(x.depth == 1) list.add(x.key);
        else{
            int ldepth = depth(x.left);
            int rdepth = depth(x.right);
            if(ldepth<rdepth){
                diameter(x.right,list);
            }else{
                diameter(x.left, list);
            }
            list.add(x.key);
        }
    }

    public static void main(String[] args) {
        BST<String, String> bst = new BST<>();
        bst.put("C", "abc1");
        bst.put("E", "abe");
        bst.put("A", "abc");
        bst.put("Z","ada");
        bst.put("X","adda");
        System.out.println(bst.depth());
        System.out.println(bst.depth("C"));
        System.out.println(bst.diameter());
    }

}
