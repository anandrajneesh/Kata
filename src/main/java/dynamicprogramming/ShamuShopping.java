package dynamicprogramming;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Anand_Rajneesh on 2/23/2017.
 */
public class ShamuShopping {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] shopsAndPrices = new int[n][3];
            for (int i = 0, j = 0; i < n; j = ++j % 3, i = j == 0 ? ++i : i) {
                shopsAndPrices[i][j] = in.nextInt();
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    int num = shopsAndPrices[i][j];
                    switch(j){
                        case 0:
                            shopsAndPrices[i][j] = Math.min(num+shopsAndPrices[i-1][1],num+shopsAndPrices[i-1][2]);
                            break;
                        case 1:
                            shopsAndPrices[i][j] = Math.min(num+shopsAndPrices[i-1][0],num+shopsAndPrices[i-1][2]);
                            break;
                        case 2:
                            shopsAndPrices[i][j] = Math.min(num+shopsAndPrices[i-1][1],num+shopsAndPrices[i-1][0]);
                            break;
                    }
                }
            }
            System.out.println(IntStream.of(shopsAndPrices[n-1]).min().getAsInt());
        }
    }


}
