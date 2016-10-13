package codility;

/**
 * Created by Anand_Rajneesh on 5/5/2016.
 */
public class MaxCounters {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int actualmax = 0;
        int[] counters = new int[N];

        for (int i = 0; i < A.length; i++) {
            int x = A[i] - 1;
            if (A[i] <= N) {
                counters[x] = Math.max(counters[x], actualmax) + 1;
                max = Math.max(counters[x], max);
            } else {
                actualmax = max;
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(actualmax, counters[i]);
        }

        return counters;
    }


    public static void main(String[] args) {
        MaxCounters m = new MaxCounters();
        int[] a = {3, 4, 4, 6, 1, 4, 4};
        a = m.solution(5, a);
        for (int i : a)
            System.out.println(i);
    }
}
