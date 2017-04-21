package misc.threads101;

/**
 * Created by anand_rajneesh on 12/26/2016.
 */
public class SimpleThreads {

    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements  Runnable{

        @Override
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for(String message : importantInfo){
                try {
                    Thread.sleep(2000);
                    threadMessage(message);
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done!");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        threadMessage("Starting MessageLoop thread");
        Thread t = new Thread(new MessageLoop());
        long startTime = System.currentTimeMillis();
        t.start();
        threadMessage("Waiting for MessageLoop thread to finish");
        while(t.isAlive()){
            threadMessage("Still waiting..");
            t.join(1000);
            if((System.currentTimeMillis() - startTime)>6000 && t.isAlive()){
                threadMessage("Tired of waiting..");
                t.interrupt();
                //t.join();
            }
        }
        threadMessage("finally");

    }


}
