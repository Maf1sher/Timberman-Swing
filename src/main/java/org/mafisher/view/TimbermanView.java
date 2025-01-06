package org.mafisher.view;

import org.mafisher.enums.RGBColorEnums;
import org.mafisher.model.Timberman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimbermanView extends JPanel implements ActionListener {

    private Image timberman_right;
    private Image timberman_left;
    private Image axe_right;
    private Image axe_left;
    private Image axe_right_horizontal;
    private Image axe_left_horizontal;
    
    private Image curentAxeImage;

    private final Timer timer;

    private RGBColorEnums currentColor;
    private boolean side;

    private int panelWidth;
    private int panelHeight;

    public TimbermanView() {
        axe_right = new ImageIcon(getClass().getResource("/view/axe/axe_right.png")).getImage();
        axe_left = new ImageIcon(getClass().getResource("/view/axe/axe_left.png")).getImage();
        axe_right_horizontal = new ImageIcon(getClass().getResource("/view/axe/axe_right_horizontal.png")).getImage();
        axe_left_horizontal = new ImageIcon(getClass().getResource("/view/axe/axe_left_horizontal.png")).getImage();

        timberman_left = new ImageIcon(getClass().getResource("/view/timberman/red_left.png")).getImage();
        timberman_right = new ImageIcon(getClass().getResource("/view/timberman/red_right.png")).getImage();
        
        timer = new Timer(200, this);
        currentColor = RGBColorEnums.RED;
    }

    public void draw(Timberman timberman){
        if(currentColor != timberman.getColor()){
            setTimbermanImage(timberman.getColor());
        }
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        boolean side = timberman.getSide();
        if(side){
            this.side = true;
            if(timberman.getAnimation())
                curentAxeImage = axe_left_horizontal;
        }
        else{
            this.side = false;
            if(timberman.getAnimation())
                curentAxeImage = axe_right_horizontal;
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

        int x = (int)(panelWidth / 2.0 - (double) axe_left.getWidth(null) / 2);
        int y = panelHeight - 200;

        if(side){
            g2d.drawImage(timberman_left, x - 50, y, null);
            g2d.drawImage(curentAxeImage, x - 50, y, null);
            timer.start();
        }else{
            g2d.drawImage(timberman_right, x + 50, y, null);
            g2d.drawImage(curentAxeImage, x + 50, y, null);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(side)
            curentAxeImage = axe_left;
        else
            curentAxeImage = axe_right;

        revalidate();
        repaint();
        timer.stop();
        timer.restart();
    }

    private void setTimbermanImage(RGBColorEnums color) {
        switch (color){
            case RED -> {
                timberman_left = new ImageIcon(getClass().getResource("/view/timberman/red_left.png")).getImage();
                timberman_right = new ImageIcon(getClass().getResource("/view/timberman/red_right.png")).getImage();
            }
            case GREEN -> {
                timberman_left = new ImageIcon(getClass().getResource("/view/timberman/green_left.png")).getImage();
                timberman_right = new ImageIcon(getClass().getResource("/view/timberman/green_right.png")).getImage();
            }
            case BLUE -> {
                timberman_left = new ImageIcon(getClass().getResource("/view/timberman/blue_left.png")).getImage();
                timberman_right = new ImageIcon(getClass().getResource("/view/timberman/blue_right.png")).getImage();
            }
            case YELLOW -> {
                timberman_left = new ImageIcon(getClass().getResource("/view/timberman/yellow_left.png")).getImage();
                timberman_right = new ImageIcon(getClass().getResource("/view/timberman/yellow_right.png")).getImage();
            }
            case ORANGE -> {
                timberman_left = new ImageIcon(getClass().getResource("/view/timberman/orange_left.png")).getImage();
                timberman_right = new ImageIcon(getClass().getResource("/view/timberman/orange_right.png")).getImage();
            }
        }
    }
}
