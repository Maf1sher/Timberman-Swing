package org.mafisher.view;

import org.mafisher.model.Timberman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimbermanView extends JPanel implements ActionListener {

    private final Image timberman_right;
    private final Image timberman_left;
    private final Image timberman_right_animation;
    private final Image timberman_left_animation;
    private Image curentImage;

    private final Timer timer;

    private boolean side;

    private final int panelWidth;
    private final int panelHeight;

    public TimbermanView() {

        this.setSize(800, 800);
        this.setLayout(null);
        this.setOpaque(false);

        timberman_right = new ImageIcon(getClass().getResource("/view/timberman/timberman_right.png")).getImage();
        timberman_left = new ImageIcon(getClass().getResource("/view/timberman/timberman_left.png")).getImage();
        timberman_right_animation = new ImageIcon(getClass().getResource("/view/timberman/timberman_right_animation.png")).getImage();
        timberman_left_animation = new ImageIcon(getClass().getResource("/view/timberman/timberman_left_animation.png")).getImage();

        panelWidth = this.getWidth();
        panelHeight = this.getHeight();

        timer = new Timer(200, this);

    }

    public void draw(Timberman timberman){
        boolean side = timberman.getSide();
        if(side){
            this.side = true;
            if(timberman.getAnimation())
                curentImage = timberman_left_animation;
        }
        else{
            this.side = false;
            if(timberman.getAnimation())
                curentImage = timberman_right_animation;
        }
        timberman.setAnimation(false);
        revalidate();
        repaint();
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = (int)(panelWidth / 2.0 - (double) timberman_left.getWidth(null) / 2);
        int y = panelHeight - 200;

        if(side){
            g2d.drawImage(curentImage, x - 50, y, null);
            timer.start();
        }else{
            g2d.drawImage(curentImage, x + 50, y, null);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(side)
            curentImage = timberman_left;
        else
            curentImage = timberman_right;

        revalidate();
        repaint();
        timer.stop();
        timer.restart();
    }
}
