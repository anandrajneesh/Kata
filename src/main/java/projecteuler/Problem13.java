package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Created by Anand_Rajneesh on 8/10/2016.
 */
public class Problem13 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\projecteuler\\problem13input.txt"))) {

            String tmp;
            BigInteger[] nums = new BigInteger[100];
            int i = 0;
            while ((tmp = br.readLine()) != null) {
                System.out.println(tmp);
                nums[i] = new BigInteger(tmp);
                i++;
            }

            BigInteger d = new BigInteger("0");
            for(BigInteger b : nums){
                d = d.add(b);
            }
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
