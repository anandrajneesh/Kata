package coursera.algorithms.week3;

import java.util.Arrays;

/**
 * Created by Anand_Rajneesh on 10/20/2016.
 */
public class MergeSort {

    public static void sort(int[] aux, int[] array, int low, int hi) {
        if (low == hi) return;

        int mid = (low + hi) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, hi);
        merge(aux, array, low, mid, hi);
        System.out.print(String.format("low(%s), mid(%s), high(%s)",low,mid,hi)+" Aux: ");
        Arrays.stream(aux).forEach(System.out::print);
        System.out.println();
        System.out.print(String.format("low(%s), mid(%s), high(%s)",low,mid,hi)+" Array: ");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        System.out.println();
    }

    public static void merge(int[] aux, int[] array, int low, int mid, int high) {
        int tmp = mid++;

        //copy the state of sorted items from array to aux for proper merge
        for(int i=low;i<=high;i++){
            aux[i]=array[i];
        }

        //k cannot go beyond high since we are comparing only those many items
        for (int k = low; k <= high; k++) {
            if (low > tmp) {
                array[k] = aux[mid++];
            } else if (mid>high) {
                array[k] = aux[low++];
            } else if (aux[low] > aux[mid]) {
                array[k] = aux[mid++];
            } else if (aux[low] < aux[mid]) {
                array[k] = aux[low++];
            } else {
                array[k] = aux[low++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 6, 1, 2, 7, 8, 3};
        int[] aux = {5, 4, 6, 1, 2, 7, 8, 3};
        sort(aux, array, 0, 7);
        Arrays.stream(array).forEach(System.out::print);
    }


}
