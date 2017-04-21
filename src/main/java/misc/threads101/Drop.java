package misc.threads101;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class Drop {

    private String message;

    public synchronized void put(String message){
        while(this.message != null){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted !");
            }
        }
        this.message = message;
        notifyAll();
    }

    public synchronized String take(){
        while(message == null){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        String t = message;
        message = null;
        notifyAll();
        return t;
    }
}
