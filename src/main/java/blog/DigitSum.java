package blog;

/**
 * Created by Anand_Rajneesh on 9/27/2016.
 */
public class DigitSum {

    public static void main(String[] args) {
        int i = 1234;
        int sum = 0;

        while(i>0){
            sum +=(i%10);
            i/=10;
        }
        System.out.println(sum);
    }
}
