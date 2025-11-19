package tic_tac_toe.player;

import tic_tac_toe.piece.Piece;
import tic_tac_toe.playing_strategy.IPlayingStrategy;

public class Player {
    private Piece piece;
    private IPlayingStrategy playingStrategy;
    private String name;

    public Player(String name, Piece piece, IPlayingStrategy playingStrategy) {
        this.name = name;
        this.piece = piece;
        this.playingStrategy = playingStrategy;
    }

    public String getName() {
        return this.name;
    }

    public Piece getPiece() {
        return piece;
    }
}
