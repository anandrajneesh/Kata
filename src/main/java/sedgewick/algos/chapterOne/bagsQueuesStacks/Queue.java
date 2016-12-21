package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class Queue<T> {

    private class Node{
        private T t;
        private Node next;

        public Node(T t) {
            this.t = t;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void enqueue(T t){
        if(first == null){
            first = new Node(t);
            last = first;
        }else{
            Node n = new Node(t);
            last.next = n;
            last = n;
        }
        size++;
    }

    public T dequeue(){
        if(first == null) return null;
        Node n = first;
        first = first.next;
        --size;
        if(size == 0 ){
            last = null;
        }
        return n.t;
    }

    public void concantenate(Queue<T> x){
        while(!x.isEmpty()){
            enqueue(x.dequeue());
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
