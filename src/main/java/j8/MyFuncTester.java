package j8;

/**
 * Created by Anand_Rajneesh on 6/14/2016.
 */
public class MyFuncTester {


    public static void main(String[] args) {

        MyFunc<String, Integer> intToString = x -> Integer.toString(x);

        System.out.println(intToString.process(42));
    }
}
