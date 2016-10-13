package codility;

/**
 * Created by Anand_Rajneesh on 4/18/2016.
 */
public class TapeEquillibrium {


    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int precursor = A[A.length -1];
        int result = Math.abs((sum - precursor)-precursor);
        for (int i = A.length - 2; i > 0; i--) {
            precursor +=A[i];
            int a = Math.abs((sum - precursor)-precursor);
            result = result > a ? a : result;
        }
        return result;
    }

    public static void main(String[] args) {
        TapeEquillibrium t = new TapeEquillibrium();
        int a[] = {-1000,1000};
        System.out.println(t.solution(a));
    }
}
