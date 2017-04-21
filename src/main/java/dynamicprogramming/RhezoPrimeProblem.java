package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/23/2017.
 */
public class RhezoPrimeProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long num1 = 0, num2 = 0;
        long sum = 0;
        for(int i= 0; i < t;i++){
            if(i == 0){
                num1 = in.nextLong();
            }else if(i == t-1){
                num2 = in.nextLong();
            }else{
                sum+=in.nextLong();
            }
        }
        if(t % 2 == 0){
            sum += Math.max(num1,num2);
            System.out.println(sum);
        }else{
            System.out.println(sum+num1+num2);
        }
    }
}
