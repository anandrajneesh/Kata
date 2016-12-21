package sedgewick.algos.chapterOne.programmingModel;

/**
 * Created by Anand_Rajneesh on 10/17/2016.
 */


/**
 * Sattolo's algorithm. Write a program Sattolo.java that
 * generates a unifomly distributed cycle of length N using Sattolo's algorithm.
 */
public class Sattolo {

    public static void shuffle(int[] data){
        for(int i =0; i<data.length-1;i++){
           // if(i == data.length-1) break;
            double x = Math.random();
            int tmp =  (int) (x*(data.length-i-1))+1;
            int d = data[i];
            data[i] = data[i+tmp];
            data[i+tmp] = d;
        }
    }
    public static void cycle(int[] a) {
        int N = a.length;
        for (int i = N; i > 1; i--) {
            // choose index uniformly in [0, i-1)
            int r = (int) (Math.random() * (i-1));
            int swap = a[r];
            a[r] = a[i-1];
            a[i-1] = swap;
        }
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        shuffle(data);
        for(int i : data){
            System.out.print(i+" ");
        }
    }
}
