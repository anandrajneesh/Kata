package j8;

/**
 * Created by Anand_Rajneesh on 7/5/2016.
 */
public class MyFuncStatic {

    public static String charToStr(char[] chars){
        return new String(chars);
    }

    public static String strFunc(MyFunc<String, char[]> myfunc, char[] chars){
        return myfunc.process(chars);
    }



    public static void main(String[] args) {

        System.out.println(strFunc(MyFuncStatic::charToStr, new char[] {'a','b','c'}));

    }

}
