package sedgewick.algos.chapterOne.analysisOfAlgorithms;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by anand_rajneesh on 12/15/2016.
 */
public class LocalMinimumMatrix {


    public static void main(String[] args) {
        int n = 10;
        Set<Integer> set = new HashSet<>(n*n);
        while(set.size()<n*n){
            int x = StdRandom.uniform((int) Math.pow(n,3));
            set.add(x);
        }
        int[][] matrix = new int[n][n];
        Iterator<Integer> itr = set.iterator();
        for(int i = 0;i<n*n;i++){
            int x = itr.next();
            System.out.print(x+", ");
            matrix[i/n][i%n] = x;
            if(n - i%n == 1){
                System.out.println();
            }
        }
        long time = System.currentTimeMillis();
        int[] min = findMinimum(matrix, 0, n);
        System.out.println(min[0] + " "+min[1]);
        System.out.println(System.currentTimeMillis() - time + " ms");
    }

    public static int[] findMinimum(int[][]matrix, int lo, int high){
        int index = (lo + high)/2;
        int smallestIndex = 0;
        int j = matrix[index][smallestIndex];
        for(int i =1; i<matrix.length;i++){
            int tmp = matrix[index][i];
            if(tmp < j){
                j = tmp;
                smallestIndex = i;
            }
        }
        if(bounds(index,lo,high ) && bounds(smallestIndex, 0, matrix.length)) {
            int x = matrix[index - 1][smallestIndex];
            int y = matrix[index + 1][smallestIndex];
            int a = matrix[index][smallestIndex - 1];
            int b = matrix[index][smallestIndex + 1];
            if (j < x && j < y && j < a && j < b) {
                return new int[]{index, smallestIndex};
            }
            if(x < y){
                return findMinimum(matrix, 0, index-1);
            }
            if(y <x){
                return findMinimum(matrix, index+1, matrix.length);
            }
        }
        return new int[]{-1,-1};

    }

    public static boolean bounds(int index, int lo, int high){
        return index+1<high && index-1>=lo;
    }
}
