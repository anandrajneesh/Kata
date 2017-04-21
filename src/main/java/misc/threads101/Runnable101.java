package misc.threads101;

/**
 * Created by anand_rajneesh on 12/26/2016.
 */
public class Runnable101 implements Runnable {

    private void do1(){}


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            do1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi there thread");
    }

    public static void main(String[] args) {
        try{
            Thread t = new Thread(new Runnable101());
            System.out.println("hi there");
            t.start();
            t.join();
            System.out.println("something to do here?");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
