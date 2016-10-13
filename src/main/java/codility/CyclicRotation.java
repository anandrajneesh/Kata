package codility;

/**
 * Created by Anand_Rajneesh on 4/12/2016.
 */
public class CyclicRotation {

    public static void main(String[] args) {
        int [] A = new int[4];

        int K = 9;
        new CyclicRotation().solution(A, K);
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] result = new int[A.length];
        int n = A.length;
        for(int i = 0 ; i<n ; i++ ){
            result[(i+K)%n] = A[i];
        }
        return result;
    }
}
