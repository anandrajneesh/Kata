package coursera.algoGraphs.week1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 2/10/2017.
 */
public class AdjListGraph extends Graph {

    private List<Integer>[] adj;
    private int edges;

    protected AdjListGraph(int v) {
        super(v);
        this.adj = new List[v];
        for(int i = 0; i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    @Override
    public int E() {
        return edges;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V() + " vertices, " + E() + " edges " + "\n");
        for (int v = 0; v < V(); v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
