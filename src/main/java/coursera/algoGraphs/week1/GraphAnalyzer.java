package coursera.algoGraphs.week1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Anand_Rajneesh on 2/14/2017.
 */
public class GraphAnalyzer {

    public static final String GRAPH_RESOURCES_FOLDER = "C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\resources\\graphs\\";

    public static final List<Function<Graph, Property>> GRAPH_PROPERTIES = new ArrayList<>();

    static{
        GRAPH_PROPERTIES.add(CC::new);
        GRAPH_PROPERTIES.add(Cycle::new);
        GRAPH_PROPERTIES.add(Bipartite::new);
        GRAPH_PROPERTIES.add(Euler::new);
    }


    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath(GRAPH_RESOURCES_FOLDER);
            Files.walkFileTree(path, new GraphResourceVisitor());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static class GraphResourceVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            analyzeGraph(file);
            return FileVisitResult.CONTINUE;
        }

        private void analyzeGraph(Path path){
            try {
                System.out.println("Graph analysis for: "+path);
                Graph g = GraphParser.parseGraph(path);
                System.out.println(g.toString());
                GRAPH_PROPERTIES.stream()
                        .map(f -> f.apply(g))
                        .forEach(property -> System.out.println(property.toString()+ " " + property.get()));
                System.out.println("\n==============================================");
                System.out.println("==============================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
