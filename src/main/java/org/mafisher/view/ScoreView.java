package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class ScoreView extends JPanel{

    private final JLabel label;

    public ScoreView() {
        label = new JLabel();
    }

    public void draw(int score) {
        this.removeAll();
        double panelWidth = this.getWidth();

        label.setLocation((int)(panelWidth/2 - 50), 200);
        label.setText(String.valueOf(score));
        label.setSize(100,40);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setForeground(Color.WHITE);

        this.add(label);
    }
}
