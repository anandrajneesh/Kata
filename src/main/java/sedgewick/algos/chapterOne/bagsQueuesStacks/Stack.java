package sedgewick.algos.chapterOne.bagsQueuesStacks;


import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by Anand_Rajneesh on 11/9/2016.
 */
public class Stack<T> implements Iterable<T> {

    private class Node {
        private T t;
        private Node next;

        public Node(T t) {
            this.t = t;
        }
    }

    private Node first;
    private Node queueFirst;
    private int size;
    private int modCount;

    public Stack(){}

    public Stack(Stack<T> s){
        this.first = new Node(s.first.t);
        for(Node x = first, y = s.first.next; y !=null; x.next = new Node(y.t), x = x.next, y = y.next );
        size = s.size;
    }

    public void push(T t){
        if(first == null){
            first = new Node(t);
            queueFirst = first;
        }else{
            Node n = new Node(t);
            n.next = first;
            first = n;
        }
        modCount++;
        size++;
    }

    public T pop(){
        if(size == 0) return null;
        Node n = first;
        first = first.next;
        size--;
        if(size == 0){
            queueFirst = null;
        }
        modCount++;
        return n.t;
    }

    public T peek(){
        if(size == 0) return null;
        else return first.t;
    }

    public void concantenate(Stack<T> x){
        Stack<T> q = new Stack<>();
        while(!x.isEmpty()){
            q.push(x.pop());
        }
        while(!q.isEmpty()){
            push(q.pop());
        }
        modCount++;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void enqueue(T t){
        Node x = new Node(t);
        queueFirst.next = x;
        queueFirst =x;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{

        private int mod;
        private Node current;

        public StackIterator() {
            this.mod = modCount;
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            if(mod != modCount){ throw new ConcurrentModificationException();}
            return current != null;
        }

        @Override
        public T next() {
            if(mod != modCount){ throw new ConcurrentModificationException();}
            Node n = current;
            current = current.next;
            return n.t;
        }
    }

    public static void main(String[] args) {
        Stack<Object> st1 = new Stack<>();
        st1.push(new Object());
        st1.push(new Object());
        st1.push(new Object());
        Iterator it = st1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            st1.push(new Object());
        }
        System.out.println(st1);

    }
}
