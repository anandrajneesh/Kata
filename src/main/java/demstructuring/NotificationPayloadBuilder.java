package demstructuring;

import java.util.function.Supplier;

/**
 * Created by Anand_Rajneesh on 4/27/2017.
 */
public class NotificationPayloadBuilder {

    public Supplier<NotificationPayload> deactivationPayload(Event event){
        return () -> {
            NotificationPayload p = new NotificationPayload();
            System.out.println(event.toString());
            return p;
        };
    }

    public Supplier<NotificationPayload> activationPayload(Event event) {
        return () -> {
            NotificationPayload p = new NotificationPayload();
            System.out.println(event.toString());
            return p;
        };
    }
}
