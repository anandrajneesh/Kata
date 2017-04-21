package sedgewick.algos.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by anand_rajneesh on 12/21/2016.
 */
public class AdjGraphMatrix implements Graph {

    private int V;
    private int E;
    private boolean[][] adj;

    public AdjGraphMatrix(int V){
        adj = new boolean[V][V];
        this.V = V;
    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }



    @Override
    public Iterable<Integer> adj(int v) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<V;i++){
            if(adj[v][i]) list.add(i);
        }
        return list;
    }

    @Override
    public int degree(int v) {
        int size = 0;
        for(int i = 0;i<V;i++){
            if(adj[v][i]) size++;
        }
        return size;
    }

    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }
}
