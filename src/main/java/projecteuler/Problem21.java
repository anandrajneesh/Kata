package projecteuler;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by Anand_Rajneesh on 9/27/2016.
 */

public class Problem21 {

    public static void main(String[] args) {

        Function<Integer, Integer> sumOfDivisors = x -> IntStream.rangeClosed(1, x / 2)
                .filter(e -> x % e < 1)
                .sum();

        IntPredicate isAmicable = x -> {
            int y = sumOfDivisors.apply(x);
            return x != y && x==sumOfDivisors.apply(y);
        };

        int sum = IntStream.rangeClosed(2, 10000)
                .filter(isAmicable)
                .sum();

        System.out.println(sum +"\n====\n");
    }

}
