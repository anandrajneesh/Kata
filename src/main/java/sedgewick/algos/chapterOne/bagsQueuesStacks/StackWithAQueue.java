package sedgewick.algos.chapterOne.bagsQueuesStacks;

/**
 * Created by anand_rajneesh on 12/13/2016.
 */
public class StackWithAQueue<T> {
    private Queue<T> queue = new Queue<>();


    public void push(T t){
        queue.enqueue(t);
    }

    public T pop(){
        int x = queue.size();
        for(int i =0; i<x-1;i++){
            queue.enqueue(queue.dequeue());
        }
        return queue.dequeue();
    }
}
