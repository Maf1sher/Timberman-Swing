package org.mafisher.view;

import org.mafisher.enums.RGBColorEnums;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ColorMenuView extends JPanel{

    private final JLabel background;
    private final ImageIcon background_image;
    private final JLabel timberman;
    private ImageIcon timberman_image;
    private final ImageIcon arrow;
    private final JLabel arrow_image;

    public ColorMenuView() {
        this.arrow = new ImageIcon(getClass().getResource("/view/colormenu/menu_arrow.png"));
        this.background_image = new ImageIcon(getClass().getResource("/view/colormenu/colormenu.png"));
        this.background = new JLabel(background_image);
        this.arrow_image = new JLabel(arrow);
        this.timberman = new JLabel();
    }

    public void draw(int selectedColorIndex, RGBColorEnums[] colors) {
        this.removeAll();
        this.setLayout(null);

        int x = this.getWidth() / 2 - background_image.getIconWidth() / 2;
        int y = this.getHeight() / 2 - background_image.getIconHeight() / 2;

        background.setLocation(x, y);
        background.setSize(background_image.getIconWidth(), background_image.getIconHeight());

        RGBColorEnums selectedColor = colors[selectedColorIndex];
        timberman_image = new ImageIcon(getClass().getResource("/view/timberman/" + selectedColor.name().toLowerCase() + ".png"));
        timberman.setIcon(timberman_image);

        int timbermanX = this.getWidth() / 2 - timberman_image.getIconWidth() / 2;
        int timbermanY = y - timberman_image.getIconHeight() + 150;
        timberman.setLocation(timbermanX, timbermanY);
        timberman.setSize(timberman_image.getIconWidth(), timberman_image.getIconHeight());

        arrow_image.setLocation(
                this.getWidth() / 2 - arrow.getIconWidth() / 2,
                500
                );
        arrow_image.setSize(arrow.getIconWidth(), arrow.getIconHeight());

        this.add(arrow_image);

        int colorY = y + background_image.getIconHeight() - 150;
        int colorWidth = 50;
        int colorHeight = 50;
        int spacing = 10;
        int totalWidth = (colorWidth + spacing) * 3 - spacing;
        int colorStartX = this.getWidth() / 2 - totalWidth / 2;

        this.add(timberman);

        for (int i = -1; i <= 1; i++) {
            int colorIndex = (selectedColorIndex + i + colors.length) % colors.length;
            RGBColorEnums color = colors[colorIndex];

            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(new Color(color.getR(), color.getG(), color.getB()));

            Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
            colorPanel.setBorder(blackBorder);

            colorPanel.setBounds(colorStartX + (i + 1) * (colorWidth + spacing), colorY, colorWidth, colorHeight);
            this.add(colorPanel);

            if (i == -1) {
                JLabel leftArrow = new JLabel("<", SwingConstants.CENTER);
                leftArrow.setFont(new Font("Arial", Font.BOLD, 24));
                leftArrow.setBounds(colorStartX + i * (colorWidth + spacing) + 15, colorY + 5, 40, 40);
                leftArrow.setOpaque(true);
                leftArrow.setBackground(Color.WHITE);
                leftArrow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                this.add(leftArrow);
            }

            if (i == 1) {
                JLabel rightArrow = new JLabel(">", SwingConstants.CENTER);
                rightArrow.setFont(new Font("Arial", Font.BOLD, 24));
                rightArrow.setBounds(colorStartX + (i + 1) * (colorWidth + spacing) + colorWidth + 5, colorY + 5, 40, 40);
                rightArrow.setOpaque(true);
                rightArrow.setBackground(Color.WHITE);
                rightArrow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                this.add(rightArrow);
            }
        }

        this.add(background);
    }
}