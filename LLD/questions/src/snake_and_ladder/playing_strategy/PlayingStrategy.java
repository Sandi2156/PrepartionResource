package snake_and_ladder.playing_strategy;

import snake_and_ladder.Dice;

public interface PlayingStrategy {
    public int getNextMove(Dice dice);
}
