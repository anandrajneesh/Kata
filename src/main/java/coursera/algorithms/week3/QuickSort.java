package coursera.algorithms.week3;

import dataview.Data;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 10/24/2016.
 */
public class QuickSort<T extends Comparable<T>> {

    public static void testQuickSort(){
        String [] data = new String[]{"K","C","A","T","E","L","E","P","U","I","M","Q","R","X","O","S"};

        String testString = getArrayStringSorted(data);
        //System.out.println(testString);
        System.out.print("Input ");
        print(data);

        QuickSort2<String> qs = new QuickSort2<>();
        qs.sort(data);
        System.out.print("Output ");
        print(data);
        String dataString = getArrayString(data);
        if(dataString.equals(testString)){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed");
        }
    }

    public static String getArrayString(String[] data){
        return Arrays.stream(Arrays.copyOf(data,data.length))
                .collect(Collectors.joining());
    }

    public static String getArrayStringSorted(String[] data){
        return Arrays.stream(Arrays.copyOf(data,data.length))
                .sorted().collect(Collectors.joining());
    }
    public static <T> void print(T [] array){
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
    }

    public void sort(Data<T> data){
        data.shuffle();
        sort(data,1,data.length()-1);
    }

    public void sort(Data<T> data, int low, int high){
        if(low-1>=high) return;
        int j = partition(data,low,high);
        sort(data, low, j-1);
        sort(data, j+2, high);

    }
    //find the kth smallest
    public T select(Data<T> data, int k){
        data.shuffle();
        return select(data,1,data.length()-1,k-1);
    }

    public T select(Data<T> data, int low, int high, int k){
        if(low-1>=high) return data.get(high);
        int j = partition(data, low, high);
        if(j==k) return data.get(k);
        else if(j>k) return select(data,low,j-1,k);
        else return select(data,j+2,high, k);
    }

    private int partition(Data<T> data, int low, int high) {
        T key = data.get(low-1);
        int i = low,j=high;
        while(true){
            while(less(data.get(i),key)){
                if(i==high) break;
                i++;
            }
            while(less(key,data.get(j))){
                if(j==(low-1)) break;
                j--;
            }
            if(i>=j) break;
            data.exchange(i,j);
        }
        data.exchange(j,low-1);
        return j;
    }


    private boolean less(T a, T b){
        return a.compareTo(b)<1;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{2,5,6,3,9,1,4,8,7};
        testQuickSort(ints);
    }

    public static <T extends Comparable<T>> void testQuickSelect(T[] data){
        QuickSort<T> qs = new QuickSort<>();
        System.out.println(qs.select(new Data<T>(data),2));

    }

    public static <T extends Comparable<T>> void testQuickSort(T[] data){
        String sortedString = Arrays.stream(Arrays.copyOf(data,data.length))
                .sorted().map(x->x.toString()).collect(Collectors.joining());

        QuickSort<T> qs = new QuickSort<>();
        qs.sort(new Data<>(data));

        String resultString = Arrays.stream(Arrays.copyOf(data,data.length))
                .map(x->x.toString()).collect(Collectors.joining());

        if(sortedString.equals(resultString)){
            System.out.println("Sort Passed");
        }else{
            System.out.println("Sort Failed");
        }
    }


}
