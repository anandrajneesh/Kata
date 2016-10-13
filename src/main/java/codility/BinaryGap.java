package codility;

/**
 * Created by Anand_Rajneesh on 4/11/2016.
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(new BinaryGap().solution(5));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int sum1 = 0;
        int ans = 0;
        boolean foundOne = false;
        while (N > 0) {
            if(foundOne) {
                if (N % 2 == 0) {
                    sum1++;
                } else {
                    ans = sum1 > ans ? sum1 : ans;
                    sum1 = 0;
                }
            }
            foundOne = foundOne || N%2 == 1;
            N = N / 2;
        }
        return ans;
    }
}
