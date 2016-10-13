package coursera.algorithms.week1;

/**
 * Created by Anand_Rajneesh on 5/10/2016.
 */
public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF (int n){
        id = new int[n];
        for(int i = 0 ; i<n ; i++){
            id[i] = i;
        }
    }

    private int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }

    public void union (int p, int q){
        id[p] = root(q);
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        try{
            QuickUnionUF obj = new QuickUnionUF(10);
            obj.union(8,0);
            System.out.println(obj.connected(0,8));

            obj.union(2,0);
            System.out.println(obj.connected(8,2));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
