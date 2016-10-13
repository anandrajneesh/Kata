package misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Anand_Rajneesh on 9/28/2016.
 */
public class Demo implements Do {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();

    }

    @Override
    public String do1(Object o) {
        return null;
    }

    public String do1(String o){
        return null;
    }
}
