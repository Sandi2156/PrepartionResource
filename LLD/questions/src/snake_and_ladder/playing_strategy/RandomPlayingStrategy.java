package snake_and_ladder.playing_strategy;

import snake_and_ladder.Dice;

public class RandomPlayingStrategy implements  PlayingStrategy{
    public int getNextMove(Dice dice) {
        return (int)(Math.random() * 100) % dice.getNoOfFaces();
    }
}
