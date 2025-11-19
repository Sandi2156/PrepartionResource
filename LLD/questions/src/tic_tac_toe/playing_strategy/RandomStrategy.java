package tic_tac_toe.playing_strategy;

import tic_tac_toe.Board;

public class RandomStrategy implements IPlayingStrategy{
    public int[] getNextCell(Board board) {
        return new int[]{0, 0};
    }
}
