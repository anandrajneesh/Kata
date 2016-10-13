package codility;

/**
 * Created by Anand_Rajneesh on 5/5/2016.
 */
public class PassingCars {

    public int solution(int[] A) {
        int east = 0;
        long ans =0;
        for(int i : A){
            if (i == 0){
                east ++;
            }else if (i == 1){
                ans = ans + (east);
            }
        }
        return (int)(ans > 1000000000L ? -1L : ans);
    }


    public static void main(String[] args) {
        PassingCars p = new PassingCars();
        int a [] = {0,0,1,0};
        System.out.println(p.solution(a));

    }
}
