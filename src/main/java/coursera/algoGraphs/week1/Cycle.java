package coursera.algoGraphs.week1;

/**
 * Created by Anand_Rajneesh on 2/14/2017.
 */
public final class Cycle extends AbstractGraphProperty<Boolean> {

    private boolean[] marked;
    private boolean cycle;

    public Cycle(Graph graph) {
        super(graph);
        this.marked = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                dfs(-1, i);
            }
        }
    }

    @Override
    protected Boolean compute() {
        return cycle;
    }

    private void dfs(int u, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (cycle) {
                break;
            }
            if (!marked[w]) {
                dfs(v, w);
            } else if (u != w) {
                cycle = true;
                break;
            }
        }
    }

}
