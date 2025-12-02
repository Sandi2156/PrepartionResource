package snake_and_ladder.entity;

public abstract class BoardEntity {
    protected int start;
    protected int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public abstract void show();

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
