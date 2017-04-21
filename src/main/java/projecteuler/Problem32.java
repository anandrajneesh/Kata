package projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anand_Rajneesh on 3/16/2017.
 */
public class Problem32 {

    private static Set<Integer> products = new HashSet<Integer>();

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for(int i = 2; i < 9 ; i++){
            for(int j = 4999 ; j >1234;j--){
                int x = i*j;
                if(arePandigital(i, j, x)){
                    boolean added = products.add(x);
                    if(true){
                        System.out.println(String.format("%s, %s, %s",i,j,x));
                    }
                }
            }
        }
        for (int i = 12; i <= 98; i++) {
            for (int j = 123; j <= 987; j++) {
                int x = i*j;
                if(arePandigital(i, j, x)){
                    boolean added = products.add(x);
                    if(true){
                        System.out.println(String.format("%s, %s, %s",i,j,x));
                    }
                }
            }
        }
        System.out.println(products.stream().reduce((x,y)-> x+y).get());
        System.out.println(products);
        System.out.println(System.currentTimeMillis() - time);
    }

    public static boolean arePandigital(int ... args){
        boolean [] nums = new boolean[10];
        for(int arg: args){
            for(;arg>0;){
                int x = arg%10;
                if(x == 0 || nums[x]){
                    return false;
                }else{
                    nums[x] = true;
                    arg/=10;
                }
            }
        }
        return true;
    }


}
