package misc.threads101;

/**
 * Created by anand_rajneesh on 12/26/2016.
 */
public class SynchronizedCounter {

    private int counter;

    public synchronized int value(){
        return counter;
    }

    public synchronized  void increment(){
        counter++;
    }

    public synchronized  void decrement(){
        counter--;
    }
}
