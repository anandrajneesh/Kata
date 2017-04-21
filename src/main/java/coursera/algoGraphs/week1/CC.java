package coursera.algoGraphs.week1;

import java.util.LinkedList;

/**
 * Created by Anand_Rajneesh on 2/13/2017.
 * Connected Components - Graph style
 */
public final class CC extends AbstractGraphProperty<Integer> {

    private int[] id;
    private int count;

    public CC(Graph g){
        super(g);
        this.id = new int[graph.V()];
        this.count = 0;
        for(int i = 0; i < graph.V(); i++){
            id[i] = i;
        }
        for(int i = 0; i < graph.V(); i++){
            if(id[i] == i){
                bfs(i);
                count++;
            }
        }
    }

    @Override
    protected Integer compute() {
        return count;
    }

    private void bfs(int v){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int t = queue.pop();
            for(int w : graph.adj(t)){
                if(id[w] == w) {
                    id[w] = id[t];
                    queue.add(w);
                   // this.count--;
                }
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

}
