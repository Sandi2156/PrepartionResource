package pub_sub;

import pub_sub.message.Message;
import pub_sub.subscriber.Subscriber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PubSubSystem {
    private final Map<String, Topic> topicRegistry = new ConcurrentHashMap<>();
    private static PubSubSystem instance;

    private PubSubSystem() {}

    public static synchronized PubSubSystem getInstance() {
        if(instance == null)
            instance = new PubSubSystem();
        return instance;
    }


    public void addSubscriber(String name, Subscriber subscriber) {
        Topic topic = topicRegistry.get(name);

        if(topic == null) {
            System.out.println("There is no topic with name: " + name);
            return;
        }

        topic.addSubscriber(subscriber);
    }

    public void removeSubscriber(String name, Subscriber subscriber) {
        Topic topic = topicRegistry.get(name);

        if(topic == null) {
            System.out.println("There is no topic with name: " + name);
            return;
        }

        topic.removeSubscirber(subscriber);
    }

    public void notify(String name, Message message) {
        Topic topic = topicRegistry.get(name);

        if(topic == null) {
            System.out.println("There is no topic with name: " + name);
            return;
        }

        topic.notify(message);
    }

    public void createNewTopic(String name) {
        topicRegistry.putIfAbsent(name, new Topic(name));
    }
}
