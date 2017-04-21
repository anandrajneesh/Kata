package coursera.algoGraphs.week1;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 */
public final class Bipartite extends AbstractGraphProperty<Boolean> {

    public static boolean BLUE = false;
    public static boolean RED = true;

    private boolean[] marked;
    private boolean[] colored;
    private boolean bipartite;

    public Bipartite(Graph graph) {
        super(graph);
        marked = new boolean[this.graph.V()];
        colored = new boolean[this.graph.V()];
        bipartite = true;
        for (int i = 0; i < this.graph.V(); i++) {
            if (!marked[i]) {
                dfs(i, BLUE);
            }
        }
    }

    @Override
    protected Boolean compute() {
        return bipartite;
    }

    private void dfs(int v, boolean color) {
        marked[v] = true;
        this.colored[v] = color;
        for (int w : graph.adj(v)) {
            if (!bipartite) {
                break;
            }
            if (!marked[w]) {
                dfs(w, !color);
            } else if (this.colored[w] == color) {
                bipartite = false;
                break;
            }
        }
    }

}
