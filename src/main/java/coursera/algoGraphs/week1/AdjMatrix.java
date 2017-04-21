package coursera.algoGraphs.week1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 */
public class AdjMatrix extends Graph {

    boolean[][] matrix;
    private int edges;

    protected AdjMatrix(int v) {
        super(v);
        matrix = new boolean[v][v];
    }

    @Override
    public Iterable<Integer> adj(int v) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < V(); i++) {
            if(matrix[v][i]) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public void addEdge(int v, int w) {
        matrix[v][w] = true;
        matrix[w][v] = true;
        edges++;
    }

    @Override
    public int E() {
        return edges;
    }

}
