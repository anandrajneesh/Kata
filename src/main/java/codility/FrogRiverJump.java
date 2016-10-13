package codility;

/**
 * Created by Anand_Rajneesh on 4/20/2016.
 */
public class FrogRiverJump {

    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int [] p = new int[X];

        //all -1
        for(int i = 0 ; i < X; i++){
            p[i] = -1;
        }

        for(int i =0; i<A.length; i++){
            int k = A[i];
            if(p[k-1] == -1){
                p[k-1] = i;
            }else if(p[k-1] > i){
                p[k-1] = i;
            }
        }

        int a = p[X-1];

        for(int i =0 ; i < X; i++){
            if(p[i] == -1){
                return -1;
            }
            else{
                a = a>p[i] ? a : p[i];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        FrogRiverJump f = new FrogRiverJump();
        int a [] = {1,3,1,4,2,3,5,4};
        System.out.println(f.solution(5,a));
    }
}
