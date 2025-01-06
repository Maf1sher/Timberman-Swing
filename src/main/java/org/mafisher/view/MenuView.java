package org.mafisher.view;

import javax.swing.*;

public class MenuView extends JPanel{
    public void draw(int selectedOptions){
        this.removeAll();
        double screenCol = this.getWidth();
        double screenRow = this.getHeight();

        String[] options = {"Graj", "Wyniki", "Opcje", "Wyjdz"};

        for (int i = 0; i < options.length; i++){
            JLabel label = new JLabel(options[i]);
            label.setLocation((int) (screenCol / 2), (int) (screenRow / 2 + (i-1) * 20 - 5));
            label.setSize(500,100);
            this.add(label);
        }

        JLabel label = new JLabel(">");
        label.setLocation((int) (screenCol / 2 - 20), (int) (screenRow / 2 + selectedOptions * 20 - 5));
        label.setSize(50,50);
        this.add(label);
    }
}
