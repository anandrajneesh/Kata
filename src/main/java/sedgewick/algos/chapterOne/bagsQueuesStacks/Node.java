package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class Node<T> {

    private T t;
    private Node<T> next;
    private Node<T> prev;

    public Node(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node<T> getNext() {
        return next;
    }

    public void next(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void prev(Node<T> prev) {
        this.prev = prev;
    }
}
