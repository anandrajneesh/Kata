package projecteuler;

/**
 * Created by Anand_Rajneesh on 3/16/2017.
 */
public class Problem34 {

    private static int[] factorials;

    static {
        factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * (i + 1);
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int sum = 0;
        /*for(int i = 4 ; i < 10 ; i++) {
            for (int num = factorials[i - 1]; num < factorials[i]; num += i) {
                if(isSumOfFactorialsOfDigits(num)){
                    sum+=num;
                }
            }
        }*/

        for(int i = 3; i < Integer.MAX_VALUE ; i++){
            if(isSumOfFactorialsOfDigits(i)){
                sum+=i;
            }
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - time);
    }

    public static boolean isSumOfFactorialsOfDigits(int n){
        int sum = n;
        while(n != 0){
            int r = n%10;
            if(r != 0) {
                sum -= factorials[r - 1];
            }
            n /= 10;
        }
        return sum == 0;
    }



}
