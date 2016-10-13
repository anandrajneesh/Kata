package coursera.algorithms.week1.assignment;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Anand_Rajneesh on 5/10/2016.
 */
public class PercolationStats {

    private double[] thresholds;
    private int experiments;
    private int gridSize;

    public PercolationStats(int n, int t) {
        if(n<1 || t<1){
            throw new IllegalArgumentException();
        }
        experiments = t;
        thresholds = new double[t];
        gridSize = n;
        for(int i =0; i < experiments ; i++){
            Percolation p = new Percolation(gridSize);
            double openSites = 0;
            while (!p.percolates()) {
                int x = StdRandom.uniform(gridSize) +1 ;
                int y = StdRandom.uniform(gridSize) +1;
                if (!p.isOpen(x, y)) {
                    p.open(x, y);
                    openSites++;
                }
            }
            thresholds[i] = openSites/(gridSize*gridSize);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        return mean() - (1.96*stddev())/Math.sqrt(experiments);
    }

    public double confidenceHi() {
        return mean() + (1.96*stddev())/Math.sqrt(experiments);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats s = new PercolationStats(n,t);
        System.out.println("Mean "+s.mean());
        System.out.println("Deviation " +s.stddev());
        System.out.println("Confidence hi of 95% "+s.confidenceHi());
        System.out.println("Confidence lo of 95% "+s.confidenceLo());
    }
}
