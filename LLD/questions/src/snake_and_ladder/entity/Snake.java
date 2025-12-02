package snake_and_ladder.entity;

public class Snake extends BoardEntity{

    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public void show() {
        System.out.println("Printing Snake!");
    }
}
