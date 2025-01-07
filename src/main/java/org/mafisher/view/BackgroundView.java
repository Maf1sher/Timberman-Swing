package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class BackgroundView extends JPanel {

    private final Image backgroundImage;

    public BackgroundView() {
        backgroundImage = new ImageIcon(this.getClass().getResource("/view/background/background.png")).getImage();
    }

    public void draw(){
        revalidate();
        repaint();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0, 0, null);
    }
}
