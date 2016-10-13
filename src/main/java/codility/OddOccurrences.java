package codility;

/**
 * Created by Anand_Rajneesh on 4/18/2016.
 */
public class OddOccurrences {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        for (int i : A) {
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        OddOccurrences o = new OddOccurrences();
        int a[] = {1, 1, 2, 2, 4, 5, 5};
        System.out.println(o.solution(a));
    }
}
