package org.mafisher.view;

import javax.swing.*;
import java.awt.*;

public class MenuView {
    public void draw(JPanel panel, int selectedOptions){
        panel.removeAll();
        double screenCol = panel.getSize().getWidth();
        double screenRow = panel.getSize().getHeight();

        String[] options = {"Graj", "Wyniki", "Opcje", "Wyjdz"};

        for (int i = 0; i < options.length; i++){
            JLabel label = new JLabel(options[i]);
            label.setLocation((int) (screenCol / 2), (int) (screenRow / 2 + (i-1) * 20 - 5));
            label.setSize(500,100);
            panel.add(label);
        }

        JLabel label = new JLabel(">");
        label.setLocation((int) (screenCol / 2 - 20), (int) (screenRow / 2 + selectedOptions * 20 - 5));
        label.setSize(50,50);
        panel.add(label);
    }
}
