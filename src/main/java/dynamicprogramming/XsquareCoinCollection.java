package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/24/2017.
 */
public class XsquareCoinCollection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong();
            long sum = 0, tmp = 0;
            while (n-- > 0) {
                long num = in.nextLong();
                if (num <= k) {
                    tmp += num;
                } else {
                    sum = Math.max(sum, tmp);
                    tmp = 0;
                }
            }
            sum = Math.max(sum, tmp);
            System.out.println(sum);
        }
    }
}
