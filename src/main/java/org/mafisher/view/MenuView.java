package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel{

    private final Image menu;
    private final Image menu_arrow;

    private int selectedOptions;

    public MenuView(){
        menu = new ImageIcon(getClass().getResource("/view/menu/menu.png")).getImage();
        menu_arrow = new ImageIcon(getClass().getResource("/view/menu/menu_arrow.png")).getImage();
    }

    public void draw(int selectedOptions){
//        this.removeAll();
//        double screenCol = this.getWidth();
//        double screenRow = this.getHeight();
//
//        String[] options = {"Graj", "Wyniki", "Opcje", "Wyjdz"};
//
//        for (int i = 0; i < options.length; i++){
//            JLabel label = new JLabel(options[i]);
//            label.setLocation((int) (screenCol / 2), (int) (screenRow / 2 + (i-1) * 20 - 5));
//            label.setSize(500,100);
//            this.add(label);
//        }
//
//        JLabel label = new JLabel(">");
//        label.setLocation((int) (screenCol / 2 - 20), (int) (screenRow / 2 + selectedOptions * 20 - 5));
//        label.setSize(50,50);
//        this.add(label);
        this.selectedOptions = selectedOptions;
        revalidate();
        repaint();
    }

    @Override
    public void paint(Graphics g){
        int width = getWidth();
        int height = getHeight();

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(
                menu,
                width / 2 - menu.getWidth(null) / 2,
                height / 2 - menu.getHeight(null) / 2,
                null
        );

        g2d.drawImage(
                menu_arrow,
                width / 2 - 100,
                height / 2 - 102 + 65 * selectedOptions,
                null
        );
    }
}
