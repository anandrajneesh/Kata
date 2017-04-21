package misc.threads101;

/**
 * Created by anand_rajneesh on 12/26/2016.
 */
public class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}