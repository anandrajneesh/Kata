package projecteuler;

import coursera.algorithms.week3.QuickSort2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 10/26/2016.
 */
public class Problem22 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\projecteuler\\problem22.txt"))){

            String[] names = br.lines()
                    .map(x-> x.split(","))
                    .flatMap(Arrays::stream)
                    .map(x->x.substring(x.indexOf("\"")+1, x.lastIndexOf("\"")))
                    .toArray(String[]::new);
            QuickSort2<String> qs = new QuickSort2<>();
            qs.sort(names);
            for(String name : names){
                System.out.println(name);
            }

            long answer = 0;
            for(int i =0; i<names.length;i++){
                String name = names[i];
                int sum =0;
                for(char c: name.toCharArray()){
                    sum+=c-64;
                }
                answer +=(sum*(i+1));
            }

            System.out.println(answer);
          /*  br.lines()
                    .map(x-> x.split(","))
                    .flatMap(Arrays::stream)
                    .map(x->x.substring(x.indexOf("\"")+1, x.lastIndexOf("\"")))
                    .collect()

                    .sorted()
                    .forEach(System.out::println);*/


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
