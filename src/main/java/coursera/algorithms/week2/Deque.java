package coursera.algorithms.week2;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anand_Rajneesh on 10/7/2016.
 */
public class Deque<Item> implements Iterable<Item> {
   /* public Deque()                           // construct an empty deque
    public boolean isEmpty()                 // is the deque empty?
    public int size()                        // return the number of items on the deque
    public void addFirst(Item item)          // add the item to the front
    public void addLast(Item item)           // add the item to the end
    public Item removeFirst()                // remove and return the item from the front
    public Item removeLast()                 // remove and return the item from the end
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    public static void main(String[] args)   // unit testing*/

    private int size;
    private Node start;
    private Node end;

    public Deque(){

    }

    public boolean isEmpty(){
        return size ==0;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item t){
        if(t == null){
            throw new NullPointerException();
        }
        Node node = new Node(t);
        if(size == 0){
            start = node;
            end = node;
        }else{
            node.next = start;
            start.prev = node;
            start = node;
        }
        size++;
    }

    public void addLast(Item t){
        if(t == null){
            throw new NullPointerException();
        }
        Node node = new Node(t);
        if(size == 0){
            start = node;
            end = node;
        }else{
            end.next = node;
            node.prev = end;
            end = node;
        }
        size++;
    }

    public Item removeFirst(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        Node node = start;
        start = node.next;
        if(size > 1){
            start.prev = null;
            node.next = null;
        }else if(size == 1){
            end = null;
        }
        size--;
        return node.t;
    }

    public Item removeLast(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        Node node = end;
        end = node.prev;
        if(size > 1) {
            end.next = null;
            node.prev = null;
        }else if(size == 1){
            start = null;
        }
        size--;
        return node.t;
    }

    public Iterator<Item> iterator(){
        return new Iterator<Item>() {
            private Node current = start;

            @Override
            public boolean hasNext() {
                return !(size == 0 || current == null);
            }

            @Override
            public Item next() {
                if(size == 0 || current == null){
                    throw new NoSuchElementException();
                }
                Item t = current.t;
                current = current.next;
                return t;
            }
        };
    }

    private class Node{
        private Item t;
        private Node next;
        private Node prev;

        public Node(Item t){
            this.t = t;
        }
    }



}
