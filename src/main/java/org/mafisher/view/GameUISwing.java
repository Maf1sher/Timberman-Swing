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
import java.util.concurrent.CountDownLatch;

public class GameUISwing implements GameUI{

    private JFrame frame;
    private final JPanel mainPanel;
    private final List<JComponent> components;

    private final JPanel boardPanel;
    private final JPanel menuPanel;
    private final JPanel timbermanPanel;
    private final JPanel scorePanel;
    private final JPanel timerPanel;
    private final JPanel gameOverPanel;

    private final int windowWidth = 800;
    private final int windowHeight = 800;

    private final MenuView menuView;
    private final BoardView boardView;
    private final TimbermanView timbermanView;
    private final ScoreView scoreView;
    private final GameOverView gameOverView;
    private final TimerView timerView;

    public GameUISwing(){
        mainPanel = new JPanel();
        components = new ArrayList<>();

        menuView = new MenuView();
        boardView = new BoardView();
        timbermanView = new TimbermanView();
        scoreView = new ScoreView();
        timerView = new TimerView();
        gameOverView = new GameOverView();

        boardPanel = initialPanel();
        menuPanel = initialPanel();
        timbermanPanel = initialPanel();
        scorePanel = initialPanel();
        gameOverPanel = initialPanel();
        timerPanel = initialPanel();
    }

    @Override
    public void initial() {
        mainPanel.setSize(windowWidth,windowHeight);
        mainPanel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("Timberman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
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
    }

    @Override
    public void drawMenu(int selectedOption) {
        menuView.draw(menuPanel, selectedOption);
        components.add(menuPanel);
    }

    @Override
    public void drawBackground() {
        mainPanel.setBackground(Color.green);
    }

    @Override
    public void drawBoard(Board board) {
        boardView.draw(boardPanel, board);
        components.add(boardPanel);
    }

    @Override
    public void drawTimberman(Timberman timberman) {
        timbermanView.draw(timbermanPanel, timberman);
        components.add(timbermanPanel);
    }

    @Override
    public void drawScore(int score) {
        scoreView.draw(scorePanel, score);
        components.add(scorePanel);
    }

    @Override
    public void drwaGameOver(int score, StringBuilder nick) {
        gameOverView.draw(gameOverPanel, score, nick);
        components.add(gameOverPanel);
    }

    @Override
    public void drawTimer(int time) {
        timerView.draw(timerPanel, time);
        components.add(timerPanel);
    }

    @Override
    public void drawScoreboard(List<GameResult> scoreboard) {

    }

    @Override
    public void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors) {

    }

    private JPanel initialPanel(){
        JPanel panel = new JPanel();
        panel.setSize(windowWidth, windowHeight);
        panel.setLayout(null);
        panel.setOpaque(false);
        return panel;
    }
}
