package sedgewick.algos.graphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public class DepthFirstPaths extends Paths {

    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        super(G, s);
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                edgeTo[w] = s;
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<>();
        for(;v!=s;path.add(v),v = edgeTo[v]);
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new BasicGraph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }


}
