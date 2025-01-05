package org.mafisher.view;

import javax.swing.*;

public class TimerView {

    private final ImageIcon timerBar;
    private final ImageIcon timerFrame;
    private final ImageIcon timerBackground;

    private final JLabel timerBarLabel;
    private final JLabel timerFrameLabel;
    private final JLabel timerBackgroundLabel;

    public TimerView(){
        timerBar = new ImageIcon(getClass().getResource("/view/timer/timerbar.png"));
        timerFrame = new ImageIcon(getClass().getResource("/view/timer/timerframe.png"));
        timerBackground = new ImageIcon(getClass().getResource("/view/timer/timerbackground.png"));

        timerBarLabel = new JLabel(timerBar);
        timerFrameLabel = new JLabel(timerFrame);
        timerBackgroundLabel = new JLabel(timerBackground);
    }

    public void draw(JPanel panel, int time) {
        panel.removeAll();

        int x = panel.getWidth() / 2 - timerBar.getIconWidth() / 2;
        int y = 75;


        int width = timerBar.getIconWidth();
        int height = timerBar.getIconHeight();

        timerFrameLabel.setIcon(timerFrame);

        timerFrameLabel.setLocation(x, y);
        timerBarLabel.setLocation(x, y);
        timerBackgroundLabel.setLocation(x, y);

        timerFrameLabel.setSize(width, height);
        timerBarLabel.setSize((int)(width * (time / 100.0)), height);
        timerBackgroundLabel.setSize(width, height);

        panel.add(timerFrameLabel);
        panel.add(timerBarLabel);
        panel.add(timerBackgroundLabel);
    }
}
