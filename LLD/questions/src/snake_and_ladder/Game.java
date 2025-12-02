package snake_and_ladder;

import snake_and_ladder.entity.BoardEntity;
import snake_and_ladder.player.Player;
import snake_and_ladder.subject.Subject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game extends Subject {
    private Board board;
    private Deque<Player> players;
    private Dice dice;

    private Player isGameFinished() {
        for(Player player: this.players) {
            if(player.getCurPos() == board.getLastCellNo()) {
                return player;
            }
        }

        return null;
    }

    public Game(int noOfCells, int noOfFaces, BoardEntity[] boardEntities, Player[] players) {
        super(players);

        this.dice = new Dice(noOfFaces);

        this.players = new ArrayDeque<>();
        for(Player player: players) {
            this.players.addLast(player);
        }

        this.board = new Board(noOfCells, boardEntities);

    }

    @Override
    public void notify(String message) {

    }



    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while(this.isGameFinished() == null) {
            Player player = players.pollFirst();

            System.out.println();
        }
    }

}
