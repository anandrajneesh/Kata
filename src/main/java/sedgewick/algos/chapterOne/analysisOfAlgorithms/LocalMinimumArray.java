package sedgewick.algos.chapterOne.analysisOfAlgorithms;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anand_rajneesh on 12/15/2016.
 */
public class LocalMinimumArray {
    public static void main(String[] args) {
        int n = 100000;
        Set<Integer> set = new HashSet<>(n);
        for(int i = 0; i<n;i++){
            int x = StdRandom.uniform(n);
            set.add(x);
        }

        Integer[] a = set.toArray(new Integer[1]);
        StdRandom.shuffle(a);
       // a = new Integer[]{1,2,3,4,5,6,7,8,9,10,13,11,12};
        for(Integer x : a){
            System.out.print(x+", ");
        }

        System.out.println();
        System.out.println(a.length);

        long time = System.currentTimeMillis();
        System.out.println(localMinimum(a));
        System.out.println("time taken "+ (System.currentTimeMillis() - time)+ " ms");

    }


    public static int localMinimum(Integer[] array) {
        int index = (array.length + 1) / 2;
        int tmp = index;
        index = findMinima(array, index);
        if (index - 1 >= 0 && index + 1 < array.length && (array[index] < array[index - 1] || array[index] < array[index + 1])) {
            return index;
        }
        if(index < tmp){
            index = tmp+2+array.length/2;
        }else{
            index = (tmp-1)/2;
        }
        index = findMinima(array, index);
        if (index - 1 >= 0 && index + 1 < array.length && (array[index] < array[index - 1] || array[index] < array[index + 1])) {
            return index;
        }
        return -1;
    }

    public static int findMinima(Integer[] array, int index){
        while (index - 1 >= 0 && index + 1 < array.length && (array[index] > array[index - 1] || array[index] > array[index + 1])) {
            if (array[index - 1] > array[index + 1]) {
                index = (index + 1 + array.length) / 2;
            } else {
                index = (index - 1) / 2;
            }
        }
        return index;
    }

}
