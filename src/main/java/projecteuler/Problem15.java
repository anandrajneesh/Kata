package projecteuler;

import java.math.BigInteger;

/**
 * Created by Anand_Rajneesh on 8/11/2016.
 */
public class Problem15 {

    public static void main(String[] args) {
        try {
            //Lattice path calculation using NE Lattice idea
            //no of paths= N+E combinations N i.e
            /**
             * N+E              (N+E)!
             *    c        =        /
             *     N               N!*E!
             */

            long gridSize = 4;
            BigInteger fac = factorial(gridSize);
            System.out.println(factorial(8).divide(fac.multiply(fac)));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static BigInteger factorial(long num){
        return factorial(new BigInteger(Long.toString(num)));
    }


    public static BigInteger factorial(BigInteger num){
        if(num.intValue() == 1) return num;
        return num.multiply(factorial(num.add(new BigInteger("-1"))));
    }
}
