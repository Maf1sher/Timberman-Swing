package org.mafisher.view;

import org.mafisher.enums.RGBColorEnums;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ColorMenuView {

    private final JLabel background;
    private final ImageIcon background_image;
    private final JLabel timberman;
    private ImageIcon timberman_image;

    public ColorMenuView() {
        this.background_image = new ImageIcon(getClass().getResource("/view/colormenu/colormenu.png"));
        this.background = new JLabel(background_image);
        this.timberman = new JLabel();
    }

    public void draw(JPanel panel, int selectedColorIndex, RGBColorEnums[] colors) {
        panel.removeAll();
        panel.setLayout(null);

        int x = panel.getWidth() / 2 - background_image.getIconWidth() / 2;
        int y = panel.getHeight() / 2 - background_image.getIconHeight() / 2;

        background.setLocation(x, y);
        background.setSize(background_image.getIconWidth(), background_image.getIconHeight());

        RGBColorEnums selectedColor = colors[selectedColorIndex];
        timberman_image = new ImageIcon(getClass().getResource("/view/timberman/" + selectedColor.name().toLowerCase() + ".png"));
        timberman.setIcon(timberman_image);

        int timbermanX = panel.getWidth() / 2 - timberman_image.getIconWidth() / 2;
        int timbermanY = y - timberman_image.getIconHeight() + 150;
        timberman.setLocation(timbermanX, timbermanY);
        timberman.setSize(timberman_image.getIconWidth(), timberman_image.getIconHeight());

        int colorY = y + background_image.getIconHeight() - 100;
        int colorWidth = 50;
        int colorHeight = 50;
        int spacing = 10;
        int totalWidth = (colorWidth + spacing) * 3 - spacing;
        int colorStartX = panel.getWidth() / 2 - totalWidth / 2;

        panel.add(timberman);

        for (int i = -1; i <= 1; i++) {
            int colorIndex = (selectedColorIndex + i + colors.length) % colors.length;
            RGBColorEnums color = colors[colorIndex];

            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(new Color(color.getR(), color.getG(), color.getB()));

            Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
            colorPanel.setBorder(blackBorder);

            colorPanel.setBounds(colorStartX + (i + 1) * (colorWidth + spacing), colorY, colorWidth, colorHeight);
            panel.add(colorPanel);
        }

        panel.add(background);
    }
}