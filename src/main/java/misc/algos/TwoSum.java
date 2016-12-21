package misc.algos;

import java.util.stream.IntStream;

/**
 * Created by anand_rajneesh on 12/5/2016.
 */
public class TwoSum {

    public static void main(String[] args) {
        int num = 100;
        int [] array = IntStream.rangeClosed(0,100).toArray();
        Long time = System.currentTimeMillis();
        solve(num, array);
        System.out.println("1st "+(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        solve2(num, array);
        System.out.println("2nd "+(System.currentTimeMillis() - time));
    }

    public static void solve2(int num, int[] array){
        for(int i =0, j = array.length-1; i < j;){
            int sum = array[i]+array[j];
            if(sum == num){
                //System.out.println(""+array[i]+" "+array[j]);
                i++;j--;
            }
            else if (sum > num){
                j--;
            }else{
                i++;
            }
        }
    }

    public static int search(int num, int[]array){
        return search(num, array, 0, array.length-1);
    }

    public static int search(int num, int[] array, int lo, int high){
        if(high == lo) return array[high] == num ? high : -1;
        int mid = (high+lo+1)/2;
        if(array[mid] == num) return mid;
        else if(array[mid] > num) return search(num,array,lo,mid-1);
        else return search(num, array, mid, high);
    }

    public static void solve(int num, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int y = num-x;
            if(y != x) {
                int z = search(y, array);
                if (z != -1) {
                    //System.out.println(x + " " + y);
                }
            }
        }
    }
}
