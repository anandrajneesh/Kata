package j8;

/**
 * Created by Anand_Rajneesh on 6/14/2016.
 */
public class D {

    public static void main(String[] args) {
        C c = null;
        c = new C();
        c.setName("anand");
        c = process(c);
        System.out.println(c.getName());
    }


    public static C process(C c){
        //c = new C();
        //c.setName("satish");
        c = null;
        return c;
    }
}
