package tic_tac_toe;

import tic_tac_toe.enums.Symbol;
import tic_tac_toe.piece.Piece;
import tic_tac_toe.player.Player;
import tic_tac_toe.playing_strategy.ComputerStrategy;
import tic_tac_toe.playing_strategy.RandomStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        Player playerX = new Player("Sandipan", new Piece(Symbol.X), new RandomStrategy());
        Player playerO = new Player("Susama", new Piece(Symbol.O), new ComputerStrategy());

        Game game = new Game(rows, cols, Arrays.asList(playerX, playerO));
        game.start();
    }
}
