package coursera.algorithms.week3;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 10/25/2016.
 */
public class QuickSort3Way<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{2,5,6,3,9,1,4,8,7};
        testQuickSort(ints);
        String [] data = new String[]{"A","C","A","T","E","L","E","P","U","I","M","Q","R","X","O","S"};
        testQuickSort(data);
    }

    public static <T extends Comparable<T>> void testQuickSort(T[] data){
        String sortedString = Arrays.stream(Arrays.copyOf(data,data.length))
                .sorted().map(Object::toString).collect(Collectors.joining());

        QuickSort3Way<T> qs = new QuickSort3Way<>();
        qs.sort(data);

        String resultString = Arrays.stream(Arrays.copyOf(data,data.length))
                .map(Object::toString).collect(Collectors.joining());

        if(sortedString.equals(resultString)){
            System.out.println("Sort Passed");
        }else{
            System.out.println("Sort Failed");
        }
    }


    public void sort(T[] data){
        sort(data, 0 ,data.length-1);
    }

    public void sort(T[] data, int low, int high){
        if(low>=high) return;
        int i =low, lt = low, j = high;
        while(i<=j){
            if(data[i].compareTo(data[lt]) < 0){
                T tmp = data[i];
                data[i] = data[lt];
                data[lt] = tmp;
                i++;
                lt++;
            }else if(data[i].compareTo(data[lt]) > 0){
                T tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                j--;
            }else{
                i++;
            }
        }
        sort(data,low,lt-1);
        sort(data, j+1 , high);
    }



}
