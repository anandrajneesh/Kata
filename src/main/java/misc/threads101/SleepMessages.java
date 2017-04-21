package misc.threads101;

/**
 * Created by anand_rajneesh on 12/26/2016.
 */
public class SleepMessages {

    public static void main(String[] args) {
        String[] messages = new String[]{"hi","there","in","a","sleep","method","of","thread"};
        for(String message : messages){
            try {
                Thread.sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(message);
        }
    }
}
