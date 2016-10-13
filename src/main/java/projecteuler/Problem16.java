package projecteuler;

import java.util.Arrays;

/**
 * Created by Anand_Rajneesh on 9/21/2016.
 */
public class Problem16 {

    public static void main(String[] args) {
        int number[] = new int[302];
        number[0] = 1;
        for (int i = 1; i <= 1000; i++) {
            int digits = (int) Math.floor(1 + i * Math.log10(2));
            int carry = 0;
            int tmp = 0;
            for (int k = 0; k < digits; k++) {
                tmp = number[k] * 2;
                number[k] = (tmp % 10) + carry;
                carry = tmp / 10;
            }
        }

        Arrays.stream(number).forEach(System.out::print);
        System.out.println();
        int x = Arrays.stream(number)
                .reduce((a, b) -> a + b)
                .getAsInt();
        System.out.println(x);
    }
}
