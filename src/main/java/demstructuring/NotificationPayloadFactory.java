package demstructuring;

import java.util.function.Supplier;

/**
 * Created by Anand_Rajneesh on 4/27/2017.
 */
public class NotificationPayloadFactory {

    private NotificationPayloadBuilder builder;


    public Supplier<NotificationPayload> getSupplier(Event event){
        switch (event.getFlag()){
            case "1": return builder.deactivationPayload(event);
            case "2": return builder.activationPayload(event);
            default : return null;
        }

    }

}
