package org.mafisher.model;

import java.util.Random;

public class Game {
    protected Board board;
    protected Timberman timberman;
    protected int score = 0;
    protected int timer = 100;
    protected int tick = 0;
    private boolean branchLevel = false;
    private final Random rand;

    public Game() {
        this.board = new Board(10);
        this.timberman = new Timberman();
        this.rand = new Random();
    }

    public Timberman getTimberman() {
        return timberman;
    }


    protected boolean calculateTime(){
        if(tick == 20){
            timer -= score / 100 + 1;
            tick = 0;
            return true;
        }
        return false;
    }

    protected TupleBoolean generateLevel(){
        if(branchLevel){
            boolean side = rand.nextBoolean();
            branchLevel = false;
            return new TupleBoolean(side, !side);
        }
        branchLevel = true;
        return new TupleBoolean(false, false);
    }

}
