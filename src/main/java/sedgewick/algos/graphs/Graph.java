package sedgewick.algos.graphs;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public interface Graph {

    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int degree(int v);


}
