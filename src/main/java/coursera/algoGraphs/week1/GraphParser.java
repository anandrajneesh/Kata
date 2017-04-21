package coursera.algoGraphs.week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Anand_Rajneesh on 2/14/2017.
 */
public class GraphParser {

    public static Graph parseGraph(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Graph g = new AdjListGraph(Integer.parseInt(br.readLine()));
            br.lines()
                    .map(s -> s.split(" "))
                    .forEach(t -> g.addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
            return g;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Graph parseGraph(Path path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            Graph g = new AdjListGraph(Integer.parseInt(br.readLine()));
            br.lines()
                    .map(s -> s.split(" "))
                    .forEach(t -> g.addEdge(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
            return g;
        } catch (Exception e) {
            throw e;
        }
    }

}
