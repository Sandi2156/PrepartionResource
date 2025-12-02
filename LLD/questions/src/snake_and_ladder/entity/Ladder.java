package snake_and_ladder.entity;

public class Ladder extends BoardEntity{
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public void show() {
        System.out.println("Printing Ladder!");
    }
}
