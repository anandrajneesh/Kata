package projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anand_rajneesh on 11/28/2016.
 */
public class Problem26 {

    public static void main(String[] args) {
        int sequenceLength = 0;

        for (int i = 1000; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
            }
        }
        System.out.println(sequenceLength);

        System.out.println(isPrime(1523));
    }

    public static int divide(int d){
        List<Integer> decimals = new ArrayList<>();
        int i = 10;
        int r = 0;
        int q = 0;
        while(true){
            r = i%d;
            q = i/d;
            //System.out.print(q);
            System.out.print(r);
            i = r*10;
            decimals.add(q);
        }
    }

    public static void try1(){
        int length = 0;
        double ans = 2;
        for(double d = 2; d<1000;d++){
            Double t = 1/d;
            int recurringLength = recurrence(t.toString());
            if(recurringLength > length){
                length = recurringLength;
                ans = d;
            }
        }
        System.out.println(ans);
        System.out.println(length);
    }

    public static int recurrence(String x){
        for(int firstIndexOfChar =0; firstIndexOfChar<x.length();firstIndexOfChar++){
            char character = x.charAt(firstIndexOfChar);
            for(int secondIndexOfChar = firstIndexOfChar+1;secondIndexOfChar<x.length();secondIndexOfChar++){
                if(character == x.charAt(secondIndexOfChar)){
                    String possibleRecurrence = x.substring(firstIndexOfChar,secondIndexOfChar);
                    int length = possibleRecurrence.length();
                    if(secondIndexOfChar+length < x.length() && possibleRecurrence.equals(x.substring(secondIndexOfChar, secondIndexOfChar+length))){
                        return possibleRecurrence.length();
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isPrime(int i ){
        for(int x = 2; x<Math.sqrt(i);x++){
            if(i%x==0){
                System.out.println(x);
                return false;
            }
        }
        return true;
    }
}
