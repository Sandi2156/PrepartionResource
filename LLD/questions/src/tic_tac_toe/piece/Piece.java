package tic_tac_toe.piece;

import tic_tac_toe.enums.Symbol;

public class Piece {
    private Symbol symbol;

    public Piece(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
