package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 11/11/2016.
 */
public class Demo {

    public static void main(String[] args) {
       Queue<Integer> q = new Queue<>();
        q.enqueue(0);
        q.enqueue(1);
        for(int i = 0; i<10;i++){
            int a = q.dequeue();
            int b = q.dequeue();
            q.enqueue(b);
            q.enqueue(a+b);
            System.out.println(a);
        }
    }
}
