package codility;

/**
 * Created by Anand_Rajneesh on 4/20/2016.
 */
public class Permutation {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        boolean [] map = new boolean[n+1];
        for(int i =0 ; i < n ; i++){
            long num = A[i];
            if(num <= n) {
                map[((int) num)] = !map[((int) num)];
            }
        }

        for(int i =1 ;i <=n ; i++){
            if(!map[i]) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {

        Permutation p = new Permutation();
        int a [] = {1,2,3,4,5};
        System.out.println(p.solution(a));
    }
}
