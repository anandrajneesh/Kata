package sedgewick.algos.graphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anand_rajneesh on 12/22/2016.
 */
public class BreadthFirstPaths extends Paths {

    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPaths(Graph G, int s) {
        super(G, s);
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        bfs(s);
    }

    private void bfs(int s){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(s);
        marked[s] = true;
        edgeTo[s] = s;
        while(!list.isEmpty()){
            int v = list.removeFirst();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    list.add(w);
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
        if(!marked[v]) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        for(;v!=s; list.add(v), v = edgeTo[v]);
        list.add(s);
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new BasicGraph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }
}
