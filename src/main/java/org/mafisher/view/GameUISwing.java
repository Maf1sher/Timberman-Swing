package org.mafisher.view;

import org.mafisher.controller.KeyController;
import org.mafisher.enums.RGBColorEnums;
import org.mafisher.model.Board;
import org.mafisher.model.GameResult;
import org.mafisher.model.Timberman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUISwing implements GameUI{

    private JFrame frame;
    private final JPanel mainPanel;
    private final List<JComponent> components;

    private final int windowWidth = 800;
    private final int windowHeight = 800;

    private final MenuView menuView;
    private final BoardView boardView;
    private final TimbermanView timbermanView;
    private final ScoreView scoreView;
    private final GameOverView gameOverView;
    private final TimerView timerView;
    private final ScoreboardView scoreboardView;
    private final ColorMenuView colorMenuView;
    private final BackgroundView backgroundView;

    public GameUISwing(){
        mainPanel = new JPanel();
        components = new ArrayList<>();

        menuView = new MenuView();
        boardView = new BoardView();
        timbermanView = new TimbermanView();
        scoreView = new ScoreView();
        timerView = new TimerView();
        gameOverView = new GameOverView();
        scoreboardView = new ScoreboardView();
        colorMenuView = new ColorMenuView();
        backgroundView = new BackgroundView();

        initialView(timbermanView);
        initialView(boardView);
        initialView(gameOverView);
        initialView(menuView);
        initialView(scoreView);
        initialView(timerView);
        initialView(scoreboardView);
        initialView(colorMenuView);
        initialView(backgroundView);
    }

    @Override
    public void initial() {
        mainPanel.setSize(windowWidth,windowHeight);
        mainPanel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("Timberman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(mainPanel);
        frame.addKeyListener(new KeyController());
    }

    @Override
    public void update() {
        mainPanel.removeAll();
        for(JComponent component : components){
            mainPanel.add(component);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        components.clear();
    }

    @Override
    public void close() {
        frame.dispose();
        System.exit(0);
    }

    @Override
    public void drawMenu(int selectedOption) {
        menuView.draw(selectedOption);
        components.add(menuView);
    }

    @Override
    public void drawBackground() {
        backgroundView.draw();
        components.add(backgroundView);
    }

    @Override
    public void drawBoard(Board board) {
        boardView.draw(board);
        components.add(boardView);
    }

    @Override
    public void drawTimberman(Timberman timberman) {
        timbermanView.draw(timberman);
        components.add(timbermanView);
    }

    @Override
    public void drawScore(int score) {
        scoreView.draw(score);
        components.add(scoreView);
    }

    @Override
    public void drwaGameOver(int score, StringBuilder nick) {
        gameOverView.draw(score, nick);
        components.add(gameOverView);
    }

    @Override
    public void drawTimer(int time) {
        timerView.draw(time);
        components.add(timerView);
    }

    @Override
    public void drawScoreboard(List<GameResult> scoreboard) {
        scoreboardView.draw(scoreboard);
        components.add(scoreboardView);
    }

    @Override
    public void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors) {
        colorMenuView.draw(selectedColorIndex, colors);
        components.add(colorMenuView);

    }

    private void initialView(JPanel panel){
        panel.setSize(windowWidth, windowHeight);
        panel.setLayout(null);
        panel.setOpaque(false);
    }
}
