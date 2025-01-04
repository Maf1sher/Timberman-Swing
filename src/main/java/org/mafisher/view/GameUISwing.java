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

    private final JPanel boardPanel;
    private final JPanel menuPanel;
    private final JPanel timbermanPanel;

    private final int windowWidth = 800;
    private final int windowHeight = 800;

    private final MenuView menuView;
    private final BoardView boardView;
    private final TimbermanView timbermanView;

    public GameUISwing(){
        mainPanel = new JPanel();
        menuView = new MenuView();
        boardView = new BoardView();
        timbermanView = new TimbermanView();
        components = new ArrayList<>();

        boardPanel = initialPanel();
        menuPanel = initialPanel();
        timbermanPanel = initialPanel();
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

    private JPanel initialPanel(){
        JPanel panel = new JPanel();
        panel.setSize(windowWidth, windowHeight);
        panel.setLayout(null);
        panel.setOpaque(false);
        return panel;
    }
}
