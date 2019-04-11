package ija.ija2018.homework2.common;

import ija.ija2018.homework2.game.Board;
import java.util.*;

public class Checkers implements Game {
    protected Board board;
    protected int size;
    protected Stack<Figure> history;

    public Checkers(Board board) {
        this.board = board;
        this.size = board.getSize(); 
        this.history = new Stack<Figure>();

        for (int i = 1; i <= size; i=i+2) {
            Man whiteMan = new Man(true);
            whiteMan.setPosition(board.getField(i, 2));
            board.getField(i, 1).put(whiteMan);

            Man blackMan = new Man(false);
            blackMan.setPosition(board.getField(i, size - 1));
            board.getField(i, size - 1).put(blackMan);
        }
        for (int i = 2; i <= size; i=i+2) {
            Man whiteMan = new Man(true);
            whiteMan.setPosition(board.getField(i, 2));
            board.getField(i, 2).put(whiteMan);

            Man blackMan = new Man(false);
            blackMan.setPosition(board.getField(i, size));
            board.getField(i, size).put(blackMan);
        }
    }

    @Override
    public boolean move(Figure figure, Field field) {
        if (figure.move(field)) {
            history.push(figure);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void undo() {
        Figure figure = history.pop();
        if (figure != null)
            figure.undo();
    }
}
