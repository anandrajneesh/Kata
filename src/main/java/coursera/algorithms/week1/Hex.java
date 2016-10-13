package coursera.algorithms.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Anand_Rajneesh on 5/19/2016.
 */
public class Hex {

    public final static int BLUE = 1;
    public final static int RED = 2;
    private int RED_TOP = 0;
    private int RED_BOTTOM;
    private int BLUE_TOP = 1;
    private int BLUE_BOTTOM;
    private int[][] backingData;
    private WeightedQuickUnionUF ufData;
    private int gridSize;

    public Hex(int n) {
        gridSize = n;
        backingData = new int[n][n];
        ufData = new WeightedQuickUnionUF(n * n + 4);
        BLUE_BOTTOM = n * n + 3;
        RED_BOTTOM = n * n + 2;
    }

    private boolean belongsToPlayer(int x, int y, int player) {
        return backingData[x][y] == player;
    }

    private boolean isOccupied(int x, int y) {
        return backingData[x][y] != 0;
    }

    private int convertHexToUf(int x, int y) {
        return x * gridSize + y + 2;
    }

    private void join(int i, int j) {
        ufData.union(i, j);
    }

    private void join(int i, int x, int y) {
        ufData.union(i, convertHexToUf(x, y));
    }

    public void place(int x, int y, int player) {
        if (isOccupied(x, y)) return;

        if (player != BLUE && player != RED) throw new IllegalArgumentException();
        int ufRep = convertHexToUf(x, y);
        backingData[x][y] = player;
        //top site with virtual dot
        if (x == 0) {
            if (player == RED) join(ufRep, RED_TOP);
            else join(ufRep, BLUE_TOP);
        }
        //bottom site with virtual dot
        if (x + 1 == gridSize) {
            if (player == RED) join(ufRep, RED_BOTTOM);
            else join(ufRep, BLUE_BOTTOM);
        }
        //top site  (x-1,y) and (x-1,y+1)
        if (x - 1 >= 0) {
            if (belongsToPlayer(x - 1, y, player)) {
                join(ufRep, x - 1, y);
            }

            if (y + 1 < gridSize && belongsToPlayer(x - 1, y + 1, player)) {
                join(ufRep, x - 1, y + 1);
            }
        }
        //left site (x,y-1)
        if (y - 1 >= 0 && belongsToPlayer(x, y - 1, player)) {
            join(ufRep, x, y - 1);
        }
        //right site (x,y+1)
        if (y + 1 < gridSize && belongsToPlayer(x, y + 1, player)) {
            join(ufRep, x, y + 1);
        }
        //bottom site (x+1,y-1) and (x+1,y)
        if (x + 1 < gridSize) {
            if (belongsToPlayer(x + 1, y, player)) {
                join(ufRep, x + 1, y);
            }
            if (y - 1 >= 0 && belongsToPlayer(x + 1, y - 1, player)) {
                join(ufRep, x + 1, y - 1);
            }
        }
    }

    public boolean winner(int player){
        if(player != RED && player != BLUE) throw new IllegalArgumentException();
        if(player == RED) return ufData.connected(RED_TOP, RED_BOTTOM);
        else return ufData.connected(BLUE_TOP, BLUE_BOTTOM);
    }

    public void draw(){
        for(int i =0; i< gridSize; i++){
            for(int k =0; k <i;k++){
                System.out.print(" ");
            }
            for(int j=0;j<gridSize;j++){
                System.out.print(" " + backingData[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try{
            int n = 13;
            Hex hex = new Hex(n);
            Scanner in = new Scanner(System.in);
            do{
                hex.draw();
                System.out.println("Enter position BLUE");
                String tmp = in.nextLine();
                hex.place(Integer.parseInt(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1]), BLUE);
                hex.draw();
                System.out.println("Enter position RED");
                tmp = in.nextLine();
                hex.place(Integer.parseInt(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1]), RED);
            }while(hex.winner(BLUE) == hex.winner(RED));
            if (hex.winner(BLUE)) {
                System.out.println("BLUE IS WINNER");
            }
            else if (hex.winner(RED)) {
                System.out.println("RED IS WINNER");
            }
            hex.draw();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
