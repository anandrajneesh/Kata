package sedgewick.algos.graphs;

/**
 * Created by anand_rajneesh on 12/29/2016.
 */
public class CC {

    private Graph g;
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph g) {
        this.g = g;
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for(int s =0; s <g.V();s++){
            if(!marked[s]){
                dfs(s);
                count++;
            }
        }
    }

    private void dfs(int s){
        marked[s] = true;
        id[s] = count;
        for(int v : g.adj(s)){
            if(!marked[v]){
                dfs(v);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }


}
