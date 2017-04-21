package sedgewick.algos.graphs;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public abstract class Paths {

    protected Graph G;
    protected int s;

    public Paths(Graph G, int s) {
        this.G = G;
        this.s = s;
    }

    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);


}
