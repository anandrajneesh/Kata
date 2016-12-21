package dataview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Anand_Rajneesh on 10/26/2016.
 */
public class View {

    private static final String ARROW = "\u2193 ";
    private static final String EMPTY = "  ";

    public void print(Object[] data){
        int length = data.length;
        //IntStream.range(0,length).forEach(System.out::print);
        //System.out.println();
        for(int i = 0; i<length;i++){
            System.out.print(" _");
        }
        System.out.println();
        for(int i=0; i<length;i++){
            System.out.print("|"+data[i]);
        }
        System.out.print("|");
        System.out.println();
        System.out.print(" ");
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i<length;i++){
            stb.append("\u00AF ");
        }
        System.out.println(stb);
    }

    public void printWithPointers(Object[] data, int ... pointers){
        int length = data.length;
        int lastP = -1;

        List<Integer> ps = Arrays.stream(pointers).mapToObj(x->x).collect(Collectors.toList());

        String pointerPositions = IntStream.range(0,length)
                .mapToObj(x->{
                    if(ps.contains(x)) return ARROW;
                    return EMPTY;
                })
                .collect(Collectors.joining());
        System.out.println(" "+pointerPositions);
        String arrayIndices =  IntStream.range(0,length).mapToObj(x->x).map(x->x.toString())
                .collect(Collectors.joining(" "));
        System.out.println(" "+arrayIndices);
        for(int i = 0; i<length;i++){
            System.out.print(" _");
        }
        System.out.println();
        for(int i=0; i<length;i++){
            System.out.print("|"+data[i]);
        }
        System.out.print("|");
        System.out.println();
        System.out.print(" ");
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i<length;i++){
            stb.append("\u00AF ");
        }
        System.out.println(stb);
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        Integer[] d = new Integer[]{0,1,2,3,4,5,6,7};
        View v = new View();
        v.printWithPointers(d,0,1,7);
    }
}
