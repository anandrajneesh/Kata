package projecteuler;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by anand_rajneesh on 11/29/2016.
 */
public class Problem30 {

    //9^5 is 59049, so we would need atleast a 5digit number to accomodate 5th power of 9.
    //fifth power of digits of a 5 digit number can add up to a 6 digit number so max would be a 6 digit number
    public static int[] fifthPows;

    static{
        fifthPows = IntStream.range(0,10)
                .map(x-> x*x*x*x*x)
                .toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(fifthPows).forEach(System.out::println);
        System.out.println("Numbers");
        Long time = System.currentTimeMillis();
        int answer = 0;
        for(int i = 11; i<999999; i++){
           if(isSumOfFifths(digits(i), i)){
               answer+=i;
               System.out.println(i);
           }
        }
        System.out.println("Answer");
        System.out.println(answer);
        System.out.println(System.currentTimeMillis()-time +" ms");
    }

    public static boolean isSumOfFifths(int[] digits, int i){
        for(int x = 9; x > 0; i -=(digits[x]*fifthPows[x]), x--){
                if(i < 0) break;
        }
        return i == 0;
    }

    public static int[] digits(int i){
        int[] digits = new int[10];
        for(;i>0;digits[i%10] = digits[i%10]+1,i/=10);
        return digits;
    }


}
