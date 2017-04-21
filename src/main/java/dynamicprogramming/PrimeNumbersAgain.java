package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 3/20/2017.
 */
public class PrimeNumbersAgain {

    private static List<Integer> primaticNos = new ArrayList<>();

    static {
        for (int i = 2; i <= 5; i++) {
            primaticNos.add((int) Math.pow(i, i));
        }
    }

    private static boolean isPrimatic(int n) {
        if (n == 0 || primaticNos.contains(n)) return true;
        if (n == 1) return false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                for (int i = n; i > 1; i--) {
                    int y = n - i;
                    if (isPrimatic(i)) {
                        if (isPrimatic(y)) {
                            if (y == 0) {
                                System.out.println(1);
                            } else {
                                System.out.println(2);
                            }
                            break;
                        }
                    }
                    if(i == 2){
                        System.out.println("this" +n);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
