package sedgewick.algos.graphs;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public abstract class Search {

    protected Graph G;
    protected int s;

    public Search(Graph G, int s){
        this.G = G;
        this.s = s;
    }
    abstract boolean marked(int v);
    abstract int count();
}
