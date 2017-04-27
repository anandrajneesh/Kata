package demstructuring;

/**
 * Created by Anand_Rajneesh on 4/27/2017.
 */
public class Service {

    private NotificationPayloadFactory factory;
    private Publisher publisher;

    public void run(Event event){
        publisher.publish(factory.getSupplier(event));
    }
}
