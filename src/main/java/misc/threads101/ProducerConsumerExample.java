package misc.threads101;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
