package projecteuler;

import java.math.BigInteger;

/**
 * Created by anand_rajneesh on 11/28/2016.
 */
public class Problem25 {

    public static void main(String[] args) {

        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        long count = 2;
        while(f2.toString().length()<1000){
            f2 = f1.add(f2);
            f1 = f2.subtract(f1);
            count++;
        }
        System.out.println(f2);
        System.out.println(count);


    }
}
