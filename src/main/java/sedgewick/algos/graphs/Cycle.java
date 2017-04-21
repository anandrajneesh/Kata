package sedgewick.algos.graphs;

import edu.princeton.cs.algs4.In;

/**
 * Created by anand_rajneesh on 12/29/2016.
 */
public class Cycle {

    private Graph g;
    private boolean[] marked;
    private boolean cycle;

    public Cycle(Graph g) {
        this.g = g;
        marked = new boolean[g.V()];
        for(int i=0;i<g.V();i++){
            if(marked[i]) {
                dfs(g, -1, i);
            }
        }
    }

    private void dfs(Graph g, int starterV, int v){
        marked[v] = true;
        if(cycle) return;
        for(int adjToV : g.adj(v)){
            if(!marked[adjToV]){
                dfs(g, v, adjToV);
            }else if(starterV != adjToV){
                cycle = true;
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new BasicGraph(new In());
        Cycle c = new Cycle(g);
        System.out.println(c.cycle);


    }

}
