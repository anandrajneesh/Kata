package misc.nodedegrees;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Created by Anand_Rajneesh on 5/18/2016.
 */
public class Solution {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\misc\\nodedegrees\\input.txt"))){

            int n = Integer.parseInt(br.readLine());
            int [] nodes = new int[n];
            String tmp = "";
            while((tmp = br.readLine())!= null){
                String[] split = tmp.split(" ");
                nodes[Integer.parseInt(split[0])-1] = nodes[Integer.parseInt(split[0])-1] +1;
                nodes[Integer.parseInt(split[1])-1] = nodes[Integer.parseInt(split[1])-1] +1;
            }

            for(int i =0; i<nodes.length;i++){
                System.out.println("Node "+(i+1) +" has degree of "+nodes[i]);
            }

        }catch(Exception e){
            e.printStackTrace();
        }



    }


}
