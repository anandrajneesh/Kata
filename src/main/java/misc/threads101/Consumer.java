package misc.threads101;

import java.util.Random;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
            System.out.format("%s MESSAGE RECEIVED: %s%n",this.hashCode(), message);
           /* try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }*/
        }
    }
}
