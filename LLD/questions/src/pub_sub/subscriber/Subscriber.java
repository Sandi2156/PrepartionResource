package pub_sub.subscriber;

import pub_sub.message.Message;

public interface Subscriber {
    public String getID();
    public void onMessage(Message message);
}
