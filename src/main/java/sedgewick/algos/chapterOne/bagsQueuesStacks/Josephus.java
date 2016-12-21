package sedgewick.algos.chapterOne.bagsQueuesStacks;

import java.util.Iterator;

/**
 * Created by Anand_Rajneesh on 11/9/2016.
 */
public class Josephus {

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        int n = 7;
        int m = 2;

        for(int i = 0; i<n; i++){
            list.add(i);
        }

        Iterator<Integer> itr = list.iterator();
        int x =-1;
        for(int i = 1;itr.hasNext(); i++){
            x = itr.next();
            if(i%m==0){
                System.out.println(x);
                itr.remove();
            }
        }
        itr.remove();
        System.out.println(x);

        System.out.println(" +"+list);
    }
}
