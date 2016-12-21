package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Iterator;

/**
 * Created by Anand_Rajneesh on 11/9/2016.
 */
public class CircularLinkedList<Key> implements Iterable<Key> {

    private int size = 0;
    private Node first = null;
    private Node last = null;

    private class Node {
        private Key key;
        private Node next;

        public Node(Key key) {
            this.key = key;
        }

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public void add(Key key) {
        if (first == null) {
            first = new Node(key);
        } else if (last == null) {
            last = new Node(key, first);
            first.next = last;
        } else {
            Node n = new Node(key, first);
            last.next = n;
            last = n;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder stb = new StringBuilder();
        for (Node n = first; n != null; stb.append(n.key), n = n.next) ;
        return stb.toString();
    }


    @Override
    public Iterator<Key> iterator() {
        return new CircularIterator();
    }

    private class CircularIterator implements Iterator<Key> {

        private Node previousOfLastReturned = null;
        private Node lastReturned = null;
        private Node current = null;


        public CircularIterator() {
            previousOfLastReturned = null;
            lastReturned = null;
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            if (current == first) {
                previousOfLastReturned = last;
            } else {
                previousOfLastReturned = lastReturned;
            }
            lastReturned = current;
            current = current.next;
            return lastReturned.key;
        }

        @Override
        public void remove() {
            if (lastReturned == null) return;
            if (previousOfLastReturned != current) {
                previousOfLastReturned.next = current;
            } else if (previousOfLastReturned != null) {
                previousOfLastReturned.next = null;
                first = last;
                last = null;
                first.next = null;
            } else {
                first = null;
            }
            lastReturned = null;
            size--;

        }
    }
}
