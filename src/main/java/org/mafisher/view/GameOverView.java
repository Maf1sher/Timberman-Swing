package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class GameOverView {

    private final ImageIcon gameOverIcon;
    private final JLabel label;
    private final JLabel scoreLabel;
    private final JTextField input;

    public GameOverView() {
        this.gameOverIcon = new ImageIcon(getClass().getResource("/view/gameover/gameover.png"));
        this.label = new JLabel(gameOverIcon);
        this.scoreLabel = new JLabel();
        this.input = new JTextField();
    }

    public void draw(JPanel gameOverPanel, int score, StringBuilder nick) {
        input.setText("");
        input.setFocusable(true);

        double panelWidth = gameOverPanel.getWidth();
        double panelHeight = gameOverPanel.getHeight();

        label.setBounds((int) (panelWidth / 2 - 190), (int) (panelHeight / 2 - 250), 380, 369);

        scoreLabel.setText(String.valueOf(score));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds((int) (panelWidth / 2 - 100), (int) (panelHeight / 2 - 75), 200, 50);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        input.setFont(new Font("Arial", Font.PLAIN, 20));
        input.setBounds((int) (panelWidth / 2 - 175), (int) (panelHeight / 2 + 50), 350, 40);
        input.setHorizontalAlignment(SwingConstants.CENTER);
        input.setBackground(new Color(54, 34, 4));
        input.setForeground(Color.WHITE);

        gameOverPanel.removeAll();
        gameOverPanel.add(scoreLabel);
        gameOverPanel.add(input);
        gameOverPanel.add(label);

        gameOverPanel.revalidate();
        gameOverPanel.repaint();

        input.requestFocus();

        for (java.awt.event.ActionListener listener : input.getActionListeners()) {
            input.removeActionListener(listener);
        }

        input.addActionListener(e -> {
            nick.append(input.getText());
            SwingUtilities.invokeLater(() -> {
                removeInputListeners(gameOverPanel);
            });
        });
    }

    private void removeInputListeners(JPanel gameOverPanel) {
        input.setFocusable(false);
        for (java.awt.event.ActionListener listener : input.getActionListeners()) {
            input.removeActionListener(listener);
        }
        gameOverPanel.removeAll();
        gameOverPanel.revalidate();
        gameOverPanel.repaint();
    }
}
