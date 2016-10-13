package codility;

/**
 * Created by Anand_Rajneesh on 4/18/2016.
 */
public class PermMissinElem {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length+1;
        long sum = 0;
        for(int i : A){
            sum +=i;
        }
        return (int)(((n/2.0)*(n+1)) - sum);
    }

    public static void main(String[] args) {
        PermMissinElem p = new PermMissinElem();
        int[] a = {2,1,3,5};
        System.out.println(p.solution(a));

    }
}
