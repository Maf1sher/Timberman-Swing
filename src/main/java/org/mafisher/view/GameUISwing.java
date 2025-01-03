package org.mafisher.view;

import org.mafisher.controller.KeyController;
import org.mafisher.enums.RGBColorEnums;
import org.mafisher.model.Board;
import org.mafisher.model.GameResult;
import org.mafisher.model.Timberman;

import javax.swing.*;
import java.util.List;

public class GameUISwing implements GameUI{

    JFrame frame;

    @Override
    public void initial() {
        frame = new JFrame();
        frame.setTitle("Timberman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.addKeyListener(new KeyController());
    }

    @Override
    public void update() {

    }

    @Override
    public void close() {
        frame.dispose();
    }

    @Override
    public void drawMenu(int selectedOption) {

    }

    @Override
    public void drawBackground() {

    }

    @Override
    public void drawBoard(Board board) {

    }

    @Override
    public void drawTimberman(Timberman timberman) {

    }

    @Override
    public void drawScore(int score) {

    }

    @Override
    public void drwaGameOver(int score, String nick) {

    }

    @Override
    public void drawTimer(int time) {

    }

    @Override
    public void drawScoreboard(List<GameResult> scoreboard) {

    }

    @Override
    public void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors) {

    }
}
