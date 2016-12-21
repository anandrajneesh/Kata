package projecteuler;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by anand_rajneesh on 11/29/2016.
 */
public class Demo {

    private static Map<BigInteger, BigInteger> cache;
    private static BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger factorial(int n){
        cache = new HashMap<>(n+1);
        cache.put(BigInteger.ONE, BigInteger.ONE);
        return factorial(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {
        // Create new scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter length and height of the Equilateral triangle
        System.out.print("Enter length of the sides" +
                " and height of the Equilateral triangle: ");

        double lengthOfSides = input.nextDouble();

        // Calculate the area & display to user
        double area = (Math.sqrt(3) / 4) * (Math.pow(lengthOfSides, 2));
        System.out.println("The area is: " + area);

        //Calculate the volume & display to user
        double volume = area * lengthOfSides;
        System.out.println("The volume of the Triangular prism is: " + volume);

        input.close();
    }

    //can't do it recursive style :(
    public static BigInteger factorial(BigInteger n)
    {
        if(!cache.containsKey(n)){
            cache.put(n, n.multiply(factorial(n.subtract(BigInteger.ONE))));
        }
        return cache.get(n);
    }

    public static BigInteger factorial1(int n) {
        BigInteger result = BigInteger.ONE;
        for (; n > 1; n--) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }
}
