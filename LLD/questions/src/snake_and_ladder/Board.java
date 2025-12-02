package snake_and_ladder;

import snake_and_ladder.entity.BoardEntity;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int noOfCells;
    private BoardEntity[] boardEntities;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int noOfCells, BoardEntity[] boardEntities) {
        this.noOfCells = noOfCells;
        this.boardEntities = boardEntities;
        this.boardEntityMap = new HashMap<>();

        for(BoardEntity boardEntity: boardEntities) {
            boardEntityMap.put(boardEntity.getStart(), boardEntity);
        }
    }

    public void showBoard() {
        System.out.println("Printing board!");
    }

    public int getUltimateEnd(int pos) {
        if(pos > noOfCells) return -1;

        while(boardEntityMap.containsKey(pos)) {
            pos = boardEntityMap.get(pos).getEnd();
        }

        return pos;
    }

    public int getLastCellNo() {
        return noOfCells;
    }
}
