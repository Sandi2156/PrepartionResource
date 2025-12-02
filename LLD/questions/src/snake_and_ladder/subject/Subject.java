package snake_and_ladder.subject;

import snake_and_ladder.observer.Observer;

public abstract class Subject {
    private Observer[] observers;

    public Subject(Observer[] observers) {
        this.observers = observers;
    }

    public abstract void notify(String message);

}
