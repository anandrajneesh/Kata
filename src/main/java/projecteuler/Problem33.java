package projecteuler;

import java.util.Arrays;

/**
 * Created by anand_rajneesh on 11/30/2016.
 */
public class Problem33 {

    public static void solve(){

        double product = 1;

        for(double i = 11; i<=99;i++){
            int[] digits = digits((int) i);
            if(digits[0] == 0) continue;

            for(double j = i+1, q = j/i; q>1 && j<=99; j++, q=j/i){
                int[]digits2 = digits((int) j);
                double num1 = 0;
                double num2 = 0;
                if(digits[0] == digits2[0]) {
                    num1 = digits2[1];
                    num2 = digits[1];
                }
                if(digits[0] == digits2[1]) {
                    num1 = digits2[0];
                    num2 = digits[1];
                }
                if(digits[1] == digits2[1]) {
                    num1 = digits2[0];
                    num2 = digits[0];
                }
                if(digits[1] == digits2[0]) {
                    num1 = digits2[1];
                    num2 = digits[0];
                }
                if(q == num1/num2){
                    System.out.println(i+" "+j);
                    product*=q;
                }

            }
        }
        System.out.println(product);
    }


    public static void main(String[] args) {
        /*double product = 1;
        for(int i = 10; i<=99; i++){
            int[] digits = digits(i);
            if(digits[0]==0) continue;
            for(int x = 11 ; x<=99 && i/x < 1;x++){
                int[] secondDigits = digits(x);
                double c = denom(digits,secondDigits);
                if(c == (x*1.0)/i){
                    System.out.println(i +" "+x);
                    product*=(c);
                }
            }
        }
        System.out.println(product);*/

        solve();
    }

    public static double denom(int[]digits, int[]secondDigits){
        if(digits[0] == secondDigits[0]) return (secondDigits[1]*1d)/digits[1];
        if(digits[0] == secondDigits[1]) return (secondDigits[0]*1d)/digits[1];
        if(digits[1] == secondDigits[0]) return (secondDigits[1]*1d)/digits[0];
        if(digits[1] == secondDigits[1]) return (secondDigits[0]*1d)/digits[0];
        return 1;
    }

    public static boolean containsDigit(double[] digits, double i){
        return Arrays.stream(digits).anyMatch(x-> x==i);
    }

    public static int[] digits(int num) {
        int[] digits = new int[2];
        for (int i = 0; num >=1; digits[i++] = num % 10, num /= 10) ;
        return digits;
    }
}
