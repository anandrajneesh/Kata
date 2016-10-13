package j8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Anand_Rajneesh on 10/3/2016.
 */
public class FunctionAvatar {

    public static boolean d(int a, int b, Function<Integer, Function<Integer, Boolean>> func){
        return func.apply(a).apply(b);

    }

    public static boolean d1(int a , int b, BiFunction<Integer, Integer, Boolean> func){
        return func.apply(a,b);
    }

    public static void main(String[] args) {
        System.out.println(d(9,3,a->b->a%b<1));
        Function<Integer, Integer> f = Function.identity();
        System.out.println(f.apply(1));
        System.out.println(d1(9,3,(a,b)->a%b<1));
    }
}
