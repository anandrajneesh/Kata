package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/21/2017.
 */
public class ChoosingJudges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            long[] scores = new long[n];
            for (int j = 0; j < n; j++) {
                scores[j] = in.nextLong();
                if(j == 1){
                    scores[j] = Math.max(scores[j], scores[0]);
                }
                else if(j > 1){
                    scores[j] = Math.max(scores[j-1], scores[j-2]+scores[j]);
                }
            }
            System.out.println("Case " + i + ": " + scores[n - 1]);
        }
    }
}
