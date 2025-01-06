package org.mafisher.view;

import org.mafisher.model.GameResult;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ScoreboardView extends JPanel{

    private final JLabel scoreboardBackground;
    private final ImageIcon scoreboardIcon;

    public ScoreboardView(){
        scoreboardIcon = new ImageIcon(getClass().getResource("/view/scoreboard/scoreboard.png"));

        scoreboardBackground = new JLabel(scoreboardIcon);
    }

    public void draw(List<GameResult> scoreboard) {
        this.removeAll();

        int x = this.getWidth() / 2 - scoreboardIcon.getIconWidth() / 2;
        int y = this.getHeight() / 2 - scoreboardIcon.getIconHeight() / 2;

        int i = 1;

        scoreboardBackground.setLocation(x, y);
        scoreboardBackground.setSize(scoreboardIcon.getIconWidth(), scoreboardIcon.getIconHeight());

        for (GameResult result : scoreboard) {
            JLabel label = new JLabel();
            label.setText(i + ": " + result.getPlayerNick() + " - " + result.getScore());
            label.setSize(300, 40);
            label.setLocation(this.getWidth() / 2 - label.getWidth() / 2, 250 + i * 30);
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setForeground(Color.WHITE);
            this.add(label);
            i++;
        }

        this.add(scoreboardBackground);
    }
}
