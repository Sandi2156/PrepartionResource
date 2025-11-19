package tic_tac_toe;

import tic_tac_toe.piece.Piece;

public class Board {
    private int rows, cols;
    private Piece[][] matrix;

    private boolean isValid(int row, int col) {
        return matrix[row][col] == null;
    }

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new Piece[rows][cols];
    }

    public void showBoard() {
        System.out.println("-------------------");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] == null ? "_" : matrix[i][j].getSymbol().name() + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public boolean addPiece(int row, int col, Piece piece) {
        if(!isValid(row, col)) return false;

        matrix[row][col] = piece;
        return true;
    }

    public Piece isInWinningState() {
        // check rows
        for(int i = 0; i < rows; i++) {
            Piece prev = matrix[i][0];
            if(prev == null) continue;
            boolean isSame = true;
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == null || !matrix[i][j].getSymbol().name().equals(prev.getSymbol().name())) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) return prev;
        }

        // check cols
        for(int j = 0; j < cols; j++) {
            Piece prev = matrix[0][j];
            if(prev == null) continue;
            boolean isSame = true;
            for(int i = 1; i < rows; i++) {
                if(matrix[i][j] == null || !matrix[i][j].getSymbol().name().equals(prev.getSymbol().name())) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) return prev;
        }

        // check diagonal

        return null;
    }

    public boolean isAnySpotLeft() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == null) return true;
            }
        }

        return false;
    }
}
