package pub_sub;

import pub_sub.message.Message;
import pub_sub.subscriber.CartSubscriber;
import pub_sub.subscriber.LogSubscriber;
import pub_sub.subscriber.Subscriber;

public class Main {
    public static void main(String[] args) {
        PubSubSystem pubSubSystem = PubSubSystem.getInstance();

        pubSubSystem.createNewTopic("ORDER_CREATED");
        pubSubSystem.createNewTopic("PAYMENT_RECEIVED");

        Subscriber cart1 = new CartSubscriber("cart1");
        Subscriber cart2 = new CartSubscriber("cart2");
        Subscriber log1 = new LogSubscriber("log1");
        Subscriber log2 = new LogSubscriber("log2");

        pubSubSystem.addSubscriber("ORDER_CREATED", cart1);
        pubSubSystem.addSubscriber("ORDER_CREATED", log1);

        pubSubSystem.addSubscriber("PAYMENT_RECEIVED", cart2);
        pubSubSystem.addSubscriber("PAYMENT_RECEIVED", log2);

        pubSubSystem.notify("PAYMENT_RECEIVED", new Message("Received payment for customer id : 10puo"));

        pubSubSystem.notify("ORDER_CREATED", new Message("Received payment for customer id : u3uoh"));
    }
}
