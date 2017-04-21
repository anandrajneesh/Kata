package misc.threads101;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class GuardedJoy {

    private boolean joy;

    public synchronized void guardedJoy(){
        System.out.println("is joy set to true?");
        while(!joy){
            try {
                System.out.println("Waiting now..");
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("joy is "+joy);
    }

    public synchronized void setJoy(boolean joy) {
        System.out.println("Setting joy to "+joy);
        this.joy = joy;
        notifyAll();
    }

    public static void main(String[] args) {
        GuardedJoy gj = new GuardedJoy();
        new Thread(()-> gj.guardedJoy()).start();
        new Thread(()->{
            try {
                Thread.sleep(4000);
                System.out.println("I m done sleeping");
                gj.setJoy(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
