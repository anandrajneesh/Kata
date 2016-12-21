package coursera.algorithms.week5;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by Anand_Rajneesh on 11/2/2016.
 */
public class LLRedBlackTree<K extends Comparable<K>, V> {
    private static boolean RED = true;
    private static boolean BLACK = false;

    private class Node {



        private K key;
        private V value;
        private int count;
        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.color = RED;
        }
    }

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private boolean isRed(Node x){
        return x != null && x.color;
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
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

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

    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    public Node add(Node x, K key, V value){
        if (x == null) return new Node(key, value);
        int diff = x.key.compareTo(key);
        if (diff < 0) {
            x.right = put(x.right, key, value);
        } else if (diff > 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.right) && isRed(x.left)) flipColors(x);
        //x.count = 1 + size(x.left) + size(x.right);
        return x;
    }



    public static void main(String[] args) {
        LLRedBlackTree<String, String> bst = new LLRedBlackTree<>();
        bst.put("C", "abc1");
        bst.put("E", "abe");
        bst.put("A", "abc");
        System.out.println(bst.floor("B"));
        System.out.println(bst.get("B"));
    }

}
