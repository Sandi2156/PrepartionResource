package tic_tac_toe.playing_strategy;

import tic_tac_toe.Board;

public interface IPlayingStrategy {
    public int[] getNextCell(Board board);
}
