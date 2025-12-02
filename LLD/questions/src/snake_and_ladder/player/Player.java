package snake_and_ladder.player;

import snake_and_ladder.Dice;
import snake_and_ladder.observer.Observer;
import snake_and_ladder.playing_strategy.PlayingStrategy;

public class Player implements Observer {
    private String name;
    private int curPos = 1;
    private PlayingStrategy playingStrategy;

    public Player(String name, PlayingStrategy playingStrategy) {
        this.name = name;
        this.playingStrategy = playingStrategy;
    }

    public int getCurPos() {
        return this.curPos;
    }

    public void setCurPos(int pos) {
        this.curPos = pos;
    }

    public String getName() {
        return this.name;
    }

    public int makeMove(Dice dice) {
        return playingStrategy.getNextMove(dice);
    }

    @Override
    public void notify(String message) {
        System.out.println(this.name + " received a message: " + message);
    }
}
