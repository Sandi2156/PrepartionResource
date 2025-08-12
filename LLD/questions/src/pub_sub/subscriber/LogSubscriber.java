package pub_sub.subscriber;

import pub_sub.message.Message;

public class LogSubscriber implements Subscriber {
    private final String id;

    public LogSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Received message: " + message.getPayload() + ", Subscriber: " + id);
    }
}
