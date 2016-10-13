package googlecodejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Anand_Rajneesh on 7/26/2016.
 */
public class AllYourBase {

    public static void main(String[] args) {
        try(/*BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\googlecodejam\\AllYourBaseA-small-practice.in"));*/
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\googlecodejam\\test.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\googlecodejam\\AllYourBaseA-small-practice.out"))
        ){
            int testCases = Integer.parseInt(br.readLine());
            for(int i =1; i<=testCases;i++) {
                String input = br.readLine();
                long minSeconds = LongStream.range(Character.MIN_RADIX,Character.MAX_RADIX+1)
                        .map(x ->{
                            List<Character> chars = input.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
                            String interpreted = chars.stream()
                                    .map(c -> Long.parseLong(Character.toString(c),(int)x))
                                    .map(c -> Long.toString(c))
                                    .collect(Collectors.joining());
                            return Long.parseLong(interpreted,10);
                        })
                        .min().getAsLong();
                bw.write("Case #"+i+": "+minSeconds+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
