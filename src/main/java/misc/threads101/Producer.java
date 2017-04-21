package misc.threads101;

import java.util.Random;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class Producer implements  Runnable {

    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    static String importantInfo[] = "abcdefghijklmnopqrstuvwxyz".split("");

    @Override
    public void run() {
        Random random = new Random();

        for (String message : importantInfo) {
            drop.put(message);
           /* try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {}*/
        }
        drop.put("DONE");
    }
}
