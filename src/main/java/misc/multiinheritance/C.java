package misc.multiinheritance;

/**
 * Created by Anand_Rajneesh on 5/18/2016.
 */
public class C implements A, B {
    public int move(int y) {
        return 0;
    }


    public static void main(String[] args) {
        try{
            A a = new C();
            System.out.println(a.move(10));

            B b = new C();
            System.out.println(b.move(10));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
