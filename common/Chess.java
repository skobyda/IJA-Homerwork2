package ija.ija2018.homework2.common;

import ija.ija2018.homework2.game.Board;

public class Chess implements Game {
    protected Board board;
    protected int size;

    public Chess(Board board) {
        this.board = board;
        this.size = board.getSize(); 

        for(int i = 1; i <= size; i++) {
            Pawn whitePawn = new Pawn(true);
            whitePawn.setPosition(board.getField(i, 2));
            board.getField(i, 2).put(whitePawn);

            Pawn blackPawn = new Pawn(false);
            blackPawn.setPosition(board.getField(i, 7));
            board.getField(i, 7).put(blackPawn);
        }

        Rook whiteRook1 = new Rook(true);
        whiteRook1.setPosition(board.getField(1, 1));
        board.getField(1, 1).put(whiteRook1);
        Rook whiteRook2 = new Rook(true);
        whiteRook2.setPosition(board.getField(8, 1));
        board.getField(8, 1).put(whiteRook2);

        Rook blackRook1 = new Rook(false);
        blackRook1.setPosition(board.getField(8, 8));
        board.getField(8, 8).put(blackRook1);
        Rook blackRook2 = new Rook(false);
        blackRook2.setPosition(board.getField(1, 8));
        board.getField(1, 8).put(blackRook2);
    }

    @Override
    public boolean move(Figure figure, Field field) {
        return figure.move(field);
    }

    @Override
    public void undo() {
        return;// TODO
    }
}
