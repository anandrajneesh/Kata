package sedgewick.algos.graphs;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public class DepthFirstSearch extends Search {

    boolean [] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        super(G, s);
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s){
        count++;
        marked[s] = true;
        for(int w: G.adj(s)){
            if(!marked[w]) dfs(G,w);
        }
    }

    @Override
    boolean marked(int v) {
        return marked[v];
    }

    @Override
    int count() {
        return count;
    }
}
