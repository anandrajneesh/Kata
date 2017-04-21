package coursera.algoGraphs.week1;

/**
 * Created by Anand_Rajneesh on 2/10/2017.
 */
public class GraphUser {


    public static int degree(Graph g , int v){
        int degree = 0;
        for(int w : g.adj(v)){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g){
        int degree = 0;
        for(int v =0; v<g.V();v++){
            int t = degree(g, v);
            degree = Math.max(degree, t);
        }
        return degree;
    }

    public static double averageDegree(Graph g){
        return 2.0 * g.E() / g.V();
    }

    public static int numberOfSelfLoops(Graph g){
        int selfLoops = 0;
        for(int v =0; v < g.V(); v++){
            for(int w : g.adj(v)){
                if(w == v){
                    selfLoops++;
                }
            }
        }
        return selfLoops/2;
    }
}
