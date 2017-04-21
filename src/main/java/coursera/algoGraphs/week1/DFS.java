package coursera.algoGraphs.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 */
public class DFS extends Paths {

    private boolean[] marked;
    private int[] edgeTo;

    public DFS(Graph g, int source) {
        super(g, source);
        marked= new boolean[g.V()];
        edgeTo = new int[g.V()];
        /*for(int i = 0; i<g.V(); i++){
            if(!marked[i]) {
                dfs(i);
            }
        }*/
        dfs(source);
        //edgeTo[source] = source;
    }

    private void dfs(int v){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        List<Integer> list = new ArrayList<>();
        list.add(v);
        for(int i = v; i != source ; i = edgeTo[v]){
            list.add(i);
        }
        list.add(source);
        Collections.reverse(list);
        return list;
    }
}
