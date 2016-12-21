package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by anand_rajneesh on 12/13/2016.
 */
public class QueueWithStacks<T> {

    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void enqueue(T t){
        s1.push(t);
    }

    public T pop(){
        while(!s1.isEmpty()) s2.push(s1.pop());
        T t = s2.pop();
        while(!s2.isEmpty()) s1.push(s2.pop());
        return t;
    }

}
