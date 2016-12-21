package sedgewick.algos.chapterOne.bagsQueuesStacks;

import edu.princeton.cs.algs4.StdIn;


/**
 * Created by anand_rajneesh on 12/12/2016.
 */
public class QueueWithOneAcessPointer<T> {

    private class Node{
        private T t;
        private Node previous;
        private Node next;
    }

    private Node first;

    public void enqueue(T t){
        if(first == null){
            first = new Node();
            first.t = t;
            first.next = first;
            first.previous = first;
        }else{
            Node x = new Node();
            x.t =t ;
            first.previous.next = x;
            x.previous = first.previous;
            first.previous = x;
            x.next = first;
        }

    }

    public T dequeue(){
        if(first == first.previous){
            Node x = first;
            first = null;
            return x.t;
        }
        else{
            Node x = first;
            first.previous.next = first.next;
            first.next.previous = first.previous;
            first = first.next;
            return x.t;
        }
    }

    public static void main(String[] args) {
        try{
            QueueWithOneAcessPointer<Integer> q = new QueueWithOneAcessPointer<>();
            while(true){
                String s = StdIn.readLine();
                switch (s){
                    case "q" : return;
                    case "pop" :
                        System.out.println("Popped "+q.dequeue());
                        break;
                    default:
                        int x = Integer.parseInt(s);
                        q.enqueue(x);
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
