package codility;

/**
 * Created by Anand_Rajneesh on 5/9/2016.
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        int x = A + A%K;
        return ((B-x+K)/K) ;
    }


    public static void main(String[] args) {
        CountDiv d = new CountDiv();
        System.out.println(d.solution(1,1,11));
    }
}
