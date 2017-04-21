package misc.algos;

import java.util.Scanner;

/**
 * Created by anand_rajneesh on 4/18/2017.
 */
public class PowerOfN {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long n = in.nextLong();
        System.out.println(powerOfN(k, n));
    }

    public static boolean powerOfN(long k ,long n){
        if(k == 1) return true;
        long div = k;
        while((div*div) <= k){
            div*=div;
        }
        if(k % div != 0){
            return false;
        }else{
            return powerOfN(k/div, n);
        }
    }
}
