package techiedelight;

/**
 * Created by Anand_Rajneesh on 3/20/2017.
 */
public class QuickSelect<T extends Comparable<T>> {

    private T[] data;

    public QuickSelect(T[] data) {
        this.data = data;
    }

    public T select(int k) {
        int pivot = pivot(0,data.length-1);
        while(pivot != k){
            if(pivot > k){
                pivot = pivot(0, pivot-1);
            }else{
                pivot = pivot(pivot+1, data.length-1);
            }
        }
        return data[pivot];
    }

    public int pivot(int lo, int high) {
        int j = high;
        for (int i = lo + 1;;) {
            while (i <= high && less(data[i], data[lo])) {
                i++;
            }
            while (j > lo && less(data[lo], data[j])) {
                j--;
            }
            if(j<i) break;
            T tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
        T tmp = data[j];
        data[j] = data[lo];
        data[lo] = tmp;
        return j;
    }

    private boolean less(T o1, T o2) {
        if (o1.compareTo(o2) < 1) return true;
        return false;
    }

    public static void main(String[] args) {
        Integer[] data= {7,4,6,3,9,1};
        QuickSelect<Integer> qs = new QuickSelect<>(data);
        for(int i = 0; i < data.length;i++){
            System.out.println(qs.select(i));
        }
        //System.out.println(qs.select(1));
    }
}
