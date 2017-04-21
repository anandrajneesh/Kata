package coursera.algoGraphs.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 */
public class BFS extends Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BFS(Graph g, int source) {
        super(g, source);
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        distTo = new int[g.V()];
        bfs(source);
    }

    private void bfs(int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);
        marked[v] = true;
        while (!queue.isEmpty()) {
            int t = queue.pop();
            for (int w : g.adj(t)) {
                if(!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = t;
                    distTo[w] = distTo[t]+1;
                }
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
