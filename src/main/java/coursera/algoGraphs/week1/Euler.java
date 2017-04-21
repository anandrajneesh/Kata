package coursera.algoGraphs.week1;

import sedgewick.algos.chapterOne.bagsQueuesStacks.Stack;

/**
 * Created by Anand_Rajneesh on 2/15/2017.
 */
public class Euler extends AbstractGraphProperty<Boolean> {

    private int edgeCount;
    private boolean[][] edges;
    private boolean notEuler;
    private Stack<Integer> cycle;

    public Euler(Graph graph) {
        super(graph);
        edgeCount = graph.E();
        notEuler = true;
        edges = new boolean[graph.V()][graph.V()];
        cycle = new Stack<>();
        cycle.push(0);
        dfs(0);
    }

    private void dfs(int vertice){
        for(int neighbour : graph.adj(vertice)){
            if(!edges[vertice][neighbour]){
                edges[vertice][neighbour] = true;
                edges[neighbour][vertice] = true;
                cycle.push(neighbour);
                --edgeCount;
                dfs(neighbour);
                if(!notEuler) break;
                cycle.pop();
                edges[vertice][neighbour] = false;
                edges[neighbour][vertice] = false;
                ++edgeCount;

            }
        }
        if(notEuler && edgeCount == 0){
            notEuler = false;
        }
    }

    @Override
    protected Boolean compute() {
        return !notEuler;
    }
}
