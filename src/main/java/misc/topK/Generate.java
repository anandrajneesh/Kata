package misc.topK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand Rajneesh on 9/24/2017.
 */
public class Generate {

    static List<String> dictionary;
    static int wordCount = 37101;
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\anand.255174\\Desktop\\generated.txt"));
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand.255174\\Desktop\\words_alpha.txt")))
        {
            dictionary = new ArrayList<>(wordCount+2);
            br.lines().forEach(dictionary::add);
            int count = Integer.MAX_VALUE;
            while(count -- > 0){
                String line = getLine();
                System.out.println(line);
                bw.write(line);
            }
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static String getLine(){
        int count = 10;
        StringBuilder stb = new StringBuilder();
        while(count-- > 0){
            int index = (int) ((Math.random() * 65536)%wordCount);
            stb.append(dictionary.get(index)).append(" ");
        }
        return stb.append("\n").toString();
    }
}
