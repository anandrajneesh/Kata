package sedgewick.algos.chapterOne.programmingModel;

/**
 * Created by Anand_Rajneesh on 10/17/2016.
 */
/**
 * Q : Binomial distribution. Estimate the number of recursive calls that would be used by the method
 * call binomial1(100, 50, .25) in Binomial.java. Develop a better implementation that is based on saving
 * computed values in an array.
 */

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Binomial.java
 *  Execution:    java Binomial N k p
 *  Dependencies: StdOut.java
 *
 *  Reads in N, k, and p as command-line arguments and prints out
 *  (N choose k) p^k (1-p)^N-k.
 *
 *  % java Binomial 5 2 .25
 *  0.263671875
 *  0.263671875
 *
 *  % java Binomial 5 3 .25
 *  0.087890625
 *  0.087890625
 *
 *  % java Binomial 5 0 .25
 *  0.2373046875
 *  0.2373046875
 *
 *  % java Binomial 5 5 .25
 *  9.765625E-4
 *  9.765625E-4
 *
 ******************************************************************************/

public class Binomial {

    private static int counter = 0;

    // slow
    public static double binomial1(int N, int k, double p) {
        counter++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) *binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
    }

    public static double binomial2(int n, int k, double p){
        double[][] computed = new double[n+2][k+2];
        for(int i =0; i < n+2; i++){
            computed[i] = new double[k+2];
        }

        for(int i =0; i<=n+1; i++){
            computed[i][0] = 0.0;
            if(i<=k+1){
                computed[0][i] = 0.0;
            }
        }
        computed[1][1]=1.0;

        for(int i =1; i <= n+1; i++){
            for(int j = 1; j<= k+1; j++){
                counter++;
                if(i == 1 && j == 1)continue;
                computed[i][j] = (1.0 - p)* computed[i-1][j] + p * computed[i-1][j-1];
            }
        }

        return computed[n+1][k+1];
    }



    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        StdOut.println(binomial2(N, k, p));
        System.out.println(counter);
    }

}

