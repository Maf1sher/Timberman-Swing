package org.mafisher.view;

import org.mafisher.model.Timberman;

import javax.swing.*;

public class TimbermanView {

    private final ImageIcon timbermanIcon;
    private final JLabel label;

    public TimbermanView() {
        timbermanIcon = new ImageIcon(getClass().getResource("/view/timberman/amongus.png"));
        label = new JLabel(timbermanIcon);
    }

    public void draw(JPanel panel, Timberman timberman){
        panel.remove(label);
        double panelWidth = panel.getSize().getWidth();
        double panelHeight = panel.getSize().getHeight();
        boolean side = timberman.getSide();
        label.setSize(timbermanIcon.getIconWidth(), timbermanIcon.getIconHeight());
        if(side){
            label.setLocation((int)(panelWidth / 2 - (double) timbermanIcon.getIconWidth() / 2 - 60), (int) (panelHeight - 200));
        }
        else{
            label.setLocation((int)(panelWidth / 2 - (double) timbermanIcon.getIconWidth() / 2 + 60), (int) (panelHeight - 200));
        }

        panel.add(label);
    }
}
