package coursera.algorithms.week4;

import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 11/1/2016.
 */
public class HeapSort<T extends Comparable<T>> {

    private T[] heap;
    private int size;

    public HeapSort(T[] data){
        heap = (T[]) new Comparable[data.length+1];
        for(int i = 0;i<data.length;i++){
            heap[i+1] = data[i];
        }
        size = data.length;
    }

    public void sink(int k){
        T violatingItem = heap[k];
        while (k * 2 <= size) {
            T child1 = heap[k * 2];
            T child2 = heap[k * 2 + 1];
            int j = k * 2;
            if (child2 != null && child1.compareTo(child2) < 0) {
                j = k * 2 + 1;
            }
            if (violatingItem.compareTo(heap[j]) < 0) {
                heap[k] = heap[j];
                heap[j] = violatingItem;
                k = j;
            } else {
                break;
            }
        }
    }

    public void makeHeap(){
        for(int k = size/2; k>=1; k--){
            sink(k);
        }
    }

    public String toString(){
        return Arrays.stream(heap).filter(x->x!=null).map(Object::toString).collect(Collectors.joining());
    }

    public void sort(){
        makeHeap();
        while(size>1) {
            T max = heap[1];
            heap[1] = heap[size];
            heap[size--] = max;
            sink(1);
        }
    }


    public static void main(String[] args) {
        String[] s = "SORTEXAMPLE".split("");
        HeapSort<String> hs = new HeapSort<>(s);
        hs.sort();
        Arrays.stream(s).forEach(System.out::print);
        System.out.println();
        System.out.println(hs);

    }
}
