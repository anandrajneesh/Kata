package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 9/21/2016.
 */
public class Problem18 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\projecteuler\\problem17input.txt"))) {
            int [][] tree = new int[15][];
            List<int[]> o = br.lines()
                    .map(e->{

                        String split[] = e.split(" ");
                        //TODO
                        int[] tmp = new int[split.length];
                        for(int i =0; i<split.length;i++){
                            tmp[i] = Integer.parseInt(split[i]);
                        }
                        return tmp;
                    })
                    //TODO
                    .collect(Collectors.toList());
            int e =0;
            for(int[] x : o){
                tree[e] = x;
                e++;
            }

            for (int i = tree.length - 1; i >= 1; i--) {
                for (int j = 0; j < tree[i].length - 1; j++) {
                    int tmp = tree[i - 1][j];
                    tmp = Math.max((tmp + tree[i][j]), (tmp + tree[i][j + 1]));
                    tree[i - 1][j] = tmp;
                }
            }
            System.out.println(tree[0][0]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
