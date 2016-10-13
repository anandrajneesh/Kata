package coursera.algorithms.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Anand_Rajneesh on 5/10/2016.
 */
public class Percolation {

    private WeightedQuickUnionUF data;
    private int count;
    private int [][] backingData;
    private boolean percolated;

    public Percolation(int n) {
        if(n <= 0) throw new IllegalArgumentException();
        data = new WeightedQuickUnionUF(n*n + 2);
        backingData = new int[n][n];
        count = n;

    }

    private int convertToUF(int i, int j){
        return (((i-1) * count) +(j-1)) + 1;
    }

    private void validate(int i, int j){
        if(i ==0 || j ==0) throw new IndexOutOfBoundsException();
        if(i > count || j > count) throw new IndexOutOfBoundsException();
    }

    public void open(int i, int j) {
        validate(i,j);

        if(backingData[i-1][j-1] == 1) return ;

        int x = i-1;
        int y = j-1;
        backingData[i-1][j-1] = 1;
        //(site = x-1,y)
        if(x>0 && isOpen(i-1,j)){
            data.union(convertToUF(i,j), convertToUF(i-1,j));
        }
        //(site = x+1,y)
        if(x<count-1 && isOpen(i+1,j)){
            data.union(convertToUF(i,j), convertToUF(i+1,j));
        }
        //(site = x,y-1)
        if(y > 0 && isOpen(i,j-1)){
            data.union(convertToUF(i,j), convertToUF(i,j-1));
        }
        //(site = x,y+1)
        if(y<count-1 && isOpen(i,j+1)){
            data.union(convertToUF(i,j), convertToUF(i,j+1));
        }
        //top row site
        if(x == 0){
            data.union(convertToUF(i,j),0);
        }
        //bottom row site
      /*  if(x == count-1){
            data.union(convertToUF(i,j), count*count+1);
        }*/

    }

    public boolean isOpen(int i, int j) {
        validate(i,j);
        return backingData[i-1][j-1] == 1;
    }

    public boolean isFull(int i, int j) {
        validate(i,j);
        return data.connected(0,convertToUF(i,j));
    }

    public boolean percolates() {
        if (percolated) return percolated;
        for (int i = 0;i<count;i++){
            if(isOpen(count, i+1) && data.connected(0, convertToUF(count,i+1))) {
                percolated = true;
                break;
            }

        }
        return percolated;
        //return data.connected(0, count * count + 1);
    }
}
