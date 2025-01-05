package org.mafisher.view;

import org.mafisher.model.Board;
import org.mafisher.model.TupleBoolean;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardView {

    private final Image leftBranch;
    private final Image rightBranch;
    private final Image middleBranch;

    private final List<JLabel> tree;

    private int panelWidth;
    private int panelHeight;


    public BoardView() {
        leftBranch = new ImageIcon(this.getClass().getResource("/view/tree/left-branch.png")).getImage();
        rightBranch = new ImageIcon(this.getClass().getResource("/view/tree/right-branch.png")).getImage();
        middleBranch = new ImageIcon(this.getClass().getResource("/view/tree/middle-branch.png")).getImage();
        tree = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            tree.add(new JLabel());
        }
    }

    public void draw(JPanel panel, Board board){
        panelWidth = panel.getWidth();
        panelHeight = panel.getHeight();

        for (JLabel label : tree){
            panel.remove(label);
        }

        List<TupleBoolean> list = board.getTree();
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).getValue1() && !list.get(i).getValue2())
                drawTrunk(tree.get(i), i);
            else if(list.get(i).getValue1())
                drawBranch(tree.get(i), 0, i, false);
            else if(list.get(i).getValue2())
                drawBranch(tree.get(i), 2, i, true);

        }

        for (JLabel label : tree){
            panel.add(label);
        }
    }

    private void drawTrunk(JLabel label, int col){
        ImageIcon icon = new ImageIcon(middleBranch);
        label.setIcon(icon);
        label.setLocation(panelWidth / 2 - icon.getIconWidth() / 2, panelHeight - 200 - col * icon.getIconHeight());
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
    }

    private void drawBranch(JLabel label, int col, int row, boolean reverse){
        ImageIcon icon;

        if(reverse)
            icon = new ImageIcon(rightBranch);
        else
            icon = new ImageIcon(leftBranch);

        label.setIcon(icon);
        label.setLocation(panelWidth / 2 - icon.getIconWidth() / 2, panelHeight - 200 - row * icon.getIconHeight());
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
    }
}
