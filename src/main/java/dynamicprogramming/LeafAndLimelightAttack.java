package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Anand_Rajneesh on 2/20/2017.
 */
public class LeafAndLimelightAttack {

    private static class NumHolder {
        private long max;
        private long sum;

        public NumHolder(long max, long sum) {
            this.max = max;
            this.sum = sum % 1000000009;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }
    }

    public static NumHolder[] array = new NumHolder[10000000];

    static{
        array[0] = new NumHolder(4, 10);
        array[1] = new NumHolder(9, 26);

        for (int i = 2; i < array.length; i++) {
            NumHolder numHolder = array[i - 2];
            long sum = numHolder.sum;
            long max = numHolder.max;
            int count = 1;
            while (count <= 4) {
                max += (i + 1);
                sum += max;
                count++;
            }
            array[i] = new NumHolder(max, sum);
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            if(n == 1){
                System.out.println(1);
            }else {
                System.out.println(array[n-2].getSum());
            }
        }
    }
}
