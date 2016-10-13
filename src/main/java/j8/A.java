package j8;

/**
 * Created by Anand_Rajneesh on 6/13/2016.
 */
public class A implements IA, IB {

    public static void main(String[] args) {
        IA a = new A();
        a.make();
        A aa = new A();
        aa.make();
        IB b = new A();
        b.make();
    }

    @Override
    public String make() {
        return "A";
    }
}
