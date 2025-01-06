package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class GameOverView extends JPanel{

    private final ImageIcon gameOverIcon;
    private final JLabel label;
    private final JLabel scoreLabel;
    private final JLabel nickLabel;

    private int panelWidth;
    private int panelHeight;

    public GameOverView() {
        this.gameOverIcon = new ImageIcon(getClass().getResource("/view/gameover/gameover.png"));
        this.label = new JLabel(gameOverIcon);
        this.scoreLabel = new JLabel();
        this.nickLabel = new JLabel();
    }

    public void draw(int score, StringBuilder nick) {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();

        label.setBounds(panelWidth / 2 - 190, panelHeight / 2 - 250, 380, 369);

        scoreLabel.setText(String.valueOf(score));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds((int) (panelWidth / 2 - 100), (int) (panelHeight / 2 - 75), 200, 50);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        nickLabel.setText(nick.toString());
        nickLabel.setFont(new Font("Arial", Font.BOLD, 40));
        nickLabel.setForeground(Color.WHITE);
        nickLabel.setBounds((int) (panelWidth / 2 - 200), (int) (panelHeight / 2), 400, 50);
        nickLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nickLabel.setVerticalAlignment(SwingConstants.CENTER);

        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        this.add(scoreLabel);
        this.add(nickLabel);
        this.add(label);

        this.revalidate();
        this.repaint();
    }
}