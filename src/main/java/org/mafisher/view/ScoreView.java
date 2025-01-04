package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class ScoreView {

    private final JLabel label;

    public ScoreView() {
        label = new JLabel();
    }

    public void draw(JPanel scoreboardPanel, int score) {
        scoreboardPanel.removeAll();
        double panelWidth = scoreboardPanel.getWidth();

        label.setLocation((int)(panelWidth/2 - 50), 150);
        label.setText(String.valueOf(score));
        label.setSize(100,40);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setForeground(Color.WHITE);

        scoreboardPanel.add(label);
    }
}
