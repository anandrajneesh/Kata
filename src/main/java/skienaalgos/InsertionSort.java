package skienaalgos;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Anand_Rajneesh on 8/1/2016.
 */
public class InsertionSort {

    public static void main(String[] args) {
        String[] items = new String[]{"b","e","z","c","a","d"};
        items = sort(items);
        System.out.println(Arrays.toString(items));
    }


    public static <T extends Comparable<T>> T[] sort(T[] items){
        for(int i = 1; i < items.length ; i++){
            int j = i;
            while(j > 0 && (items[j].compareTo(items[j-1]) < 0)){
                T tmp = items[j-1];
                items[j-1] = items[j];
                items[j] = tmp;
                j = j-1;
            }

        }
        return items;
    }

}
