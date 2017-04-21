package misc;

/**
 * Created by Anand_Rajneesh on 2/14/2017.
 */
public class Child extends Parent {

    public static boolean ret(){
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Child.ret());
        System.out.println(Parent.ret());
    }
}
