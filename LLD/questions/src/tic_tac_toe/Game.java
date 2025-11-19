package tic_tac_toe;

import tic_tac_toe.player.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Deque<Player> players;

    public Game(int rows, int cols, List<Player> playersList) {
        board = new Board(rows, cols);
        players = new ArrayDeque<Player>();

        for(Player player: playersList) {
            players.add(player);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(board.isAnySpotLeft()) {
            Player curPlayer = players.pollFirst();
            board.showBoard();
            System.out.println(curPlayer.getName() + " please make your move");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(!board.addPiece(row, col, curPlayer.getPiece())) {
                System.out.println("You have made a wrong move. Please try again");
                players.addFirst(curPlayer);
            } else {
                if(board.isInWinningState() != null) {
                    System.out.println(curPlayer.getName() + ": You have won!");
                    return;
                }
                players.addLast(curPlayer);
            }
        }

        System.out.println("Game is drawn");
    }
}
