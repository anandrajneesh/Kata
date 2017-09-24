package misc.topK;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * Created by Anand Rajneesh on 9/24/2017.
 */
public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> -1 * Integer.compare(x,y));
        pq.add(1);
        pq.add(2);
        pq.add(3);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        System.out.println(Math.random()* 370101);

        Stream<String> stream = new ArrayList<String>().stream();
        CountDownLatch latc = new CountDownLatch(4);
    }
}
