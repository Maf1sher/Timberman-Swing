package org.mafisher.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<TupleBoolean> tree;
    private final int height;

    public Board(int height) {
        this.height = height;
        tree = new ArrayList<>();
    }

    public int getHeight() {
        return height;
    }

    public List<TupleBoolean> getTree() {
        return tree;
    }

    public void addLevel(TupleBoolean level){
        tree.add(level);
    }

    public void deleteLevel(){
        tree.remove(0);
    }

    public void clearBoard(){
        tree.clear();
    }

    public TupleBoolean getFirstLevel(){
        return tree.get(0);
    }
}
