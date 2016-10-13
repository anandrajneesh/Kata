package projecteuler;

import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * Created by Anand_Rajneesh on 9/27/2016.
 */
public class Problem20 {
    public static void main(String[] args) {
        BigInteger big = new BigInteger("1");
        for(int i = 2; i<=100;i++){
            big = big.multiply(new BigInteger(Integer.toString(i)));
        }

        System.out.println(big);

        int c = big.toString().chars().mapToObj(e->e-48).reduce((a,b)->a+b).get();
        System.out.println(c);

    }
}
