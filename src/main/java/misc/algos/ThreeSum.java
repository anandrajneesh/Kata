package misc.algos;

import java.util.stream.IntStream;

/**
 * Created by anand_rajneesh on 12/6/2016.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int num = 100;
        int [] array = IntStream.rangeClosed(1,100).toArray();
        array = new int[]{1,98,2,97};
        solve(num, array);

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

    public static void solve(int num , int[] array){
        for(int i =0; i<array.length;i++){
            int num1 = array[0];
            for(int j=i+1;j<array.length;j++){
                int num2 = array[j];
                int searchNum = num - num1 - num2;
                int index = search(searchNum, array,j, array.length);
                if(index != -1 && index != i && index != j){
                    System.out.println(num1+" "+num2+" "+searchNum);
                }
            }
        }
    }


}
