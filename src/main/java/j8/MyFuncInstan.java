package j8;

/**
 * Created by Anand_Rajneesh on 7/5/2016.
 */
public class MyFuncInstan {
    public String doubleRep(double num){
        return "\""+Double.toString(num)+"\"";
    }

    public static String rep(MyFunc<String,Double> myFunc, double num){
        return myFunc.process(num);
    }

    public static void main(String[] args) {
        MyFuncInstan o = new MyFuncInstan();
        System.out.println(rep(o::doubleRep, 3.45));

    }

}
