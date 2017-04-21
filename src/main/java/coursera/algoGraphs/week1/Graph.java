package coursera.algoGraphs.week1;


/**
 * Created by Anand_Rajneesh on 2/10/2017.
 */
public abstract class Graph {

    private int v;

    protected Graph(int v) {
        this.v = v;
    }

    public abstract Iterable<Integer> adj(int v);

    public abstract void addEdge(int v, int w);
    public int V(){
        return v;
    }
    public abstract int E();



}
