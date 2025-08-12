package pub_sub;

import pub_sub.message.Message;
import pub_sub.subscriber.Subscriber;

import java.util.HashSet;
import java.util.Set;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscribers = new HashSet<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscirber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notify(Message message) {
        for(Subscriber subscriber: subscribers) {
            subscriber.onMessage(message);
        }
    }
}
