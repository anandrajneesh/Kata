package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by anand_rajneesh on 12/13/2016.
 */
public class Dequeue<T> {

    private class Node{
        private T t;
        private Node previous;
        private Node next;

        public Node(T t) {
            this.t = t;
        }
    }


    private Node head;
    private Node tail;

    public void enqueue(T t){
        Node x = new Node(t);
        if(head == null){
            head = x;
            tail = x;
            head.next = tail;
            tail.previous = head;
        }else{
            tail.next = x;
            x.previous = tail;
            tail = x;
            //head.previous = tail;
        }
    }

    /**
     * Normal enqueue adds to tail for FIFO
     * so this will add to head
     * @param t
     */
    public void enqueueHead(T t){
        Node x = new Node(t);
        if(head == null){
            head = x;
            tail = x;
            head.next = tail;
            tail.previous = head;
        }else{
            x.next = head;
            head.previous = x;
            head = x;
            //head.previous = tail;
        }
    }
}
