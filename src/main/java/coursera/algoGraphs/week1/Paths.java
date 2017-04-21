package coursera.algoGraphs.week1;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 */
public abstract class Paths {

    protected Graph g;
    protected int source;

    public Paths(Graph g, int source){
        this.g =g ;
        this.source = source;
    }

    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);
}
