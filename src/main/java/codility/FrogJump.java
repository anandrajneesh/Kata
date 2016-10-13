package codility;

/**
 * Created by Anand_Rajneesh on 4/18/2016.
 */
public class FrogJump {

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int r = (Y-X) / D;
        return ((Y-X) % D ) > 0 ? r + 1 : r;
    }

    public static void main(String[] args) {
        FrogJump f = new FrogJump();
        System.out.println(f.solution(10,85,30));
    }
}
