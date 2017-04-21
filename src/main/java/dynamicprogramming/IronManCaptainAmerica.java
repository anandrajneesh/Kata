package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/24/2017.
 */
//FIXME can use just two auxillary arrays of length 4 to compute by alternating between them
public class IronManCaptainAmerica {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] track1 = new int[n];
            int[] track2 = new int[n];
            int[] costTrack1 = new int[n - 1];
            int[] costTrack2 = new int[n - 1];

            for (int i = 0; i < n; i++) {
                track1[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                track2[i] = in.nextInt();
            }
            if (n == 1) {
                System.out.println(Math.min(track1[0], track2[0]));
            } else {

                for (int i = 0; i < n - 1; i++) {
                    costTrack1[i] = in.nextInt();
                }

                for (int i = 0; i < n - 1; i++) {
                    costTrack2[i] = in.nextInt();
                }

                int[][] x = new int[n - 1][4];

                for (int i = n - 2; i >= 0; i--) {
                    x[i][0] = track1[i + 1];
                    x[i][1] = track2[i + 1] + costTrack1[i];
                    x[i][2] = track1[i + 1] + costTrack2[i];
                    x[i][3] = track2[i + 1];
                }

                for (int i = n - 3; i >= 0; i--) {
                    x[i][0] += Math.min(x[i + 1][0], x[i + 1][1]);
                    x[i][1] += Math.min(x[i + 1][2], x[i + 1][3]);
                    x[i][2] += Math.min(x[i + 1][0], x[i + 1][1]);
                    x[i][3] += Math.min(x[i + 1][2], x[i + 1][3]);
                }

                int answer = Math.min(track1[0] + Math.min(x[0][0], x[0][1]), track2[0] + Math.min(x[0][2], x[0][3]));
                System.out.println(answer);
            }
        }
    }
}
