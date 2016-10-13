package deathmatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 5/17/2016.
 */
public class M {

    private String name;


    public static void main(String[] args) {

        M m0 = new M();
        M m1 = new M();

        m0.name = m1.name = "M1";
        some(m0,m1);

        System.out.println(m0.name+m1.name);

        final List<String> names = new ArrayList<String>(){{
                add("john");
        }
        };
    }


    private static void some(M... m){
        m[0] = m[1];
        m[1].name = "new name";
    }

}
