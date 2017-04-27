package demstructuring;

import java.util.function.Supplier;

/**
 * Created by Anand_Rajneesh on 4/27/2017.
 */
public class Publisher {

    public boolean publish(Supplier<NotificationPayload> supplier){
        System.out.println(supplier.get());
        return true;
    }
}
