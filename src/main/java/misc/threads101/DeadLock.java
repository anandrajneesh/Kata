package misc.threads101;

/**
 * Created by anand_rajneesh on 12/27/2016.
 */
public class DeadLock {

    static class Friend {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public Friend(String name) {
            this.name = name;
        }

        public synchronized void bow(Friend bower){
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());

            bower.bowBack(this);
        }

        public synchronized  void bowBack(Friend bower){
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        Friend m1 = new Friend("m1");
        Friend m2 = new Friend("m2");

        new Thread(() -> m1.bow(m2)).start();
        new Thread(() -> m2.bow(m1)).start();

    }
}
