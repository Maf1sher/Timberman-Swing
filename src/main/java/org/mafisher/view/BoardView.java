package org.mafisher.view;

import org.mafisher.model.Board;
import org.mafisher.model.TupleBoolean;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardView extends JPanel{

    private final Image leftBranch;
    private final Image rightBranch;
    private final Image middleBranch;
    private final Image trunk;

    private List<TupleBoolean> tree;

    private int panelWidth;
    private int panelHeight;


    public BoardView() {
        leftBranch = new ImageIcon(this.getClass().getResource("/view/tree/left-branch.png")).getImage();
        rightBranch = new ImageIcon(this.getClass().getResource("/view/tree/right-branch.png")).getImage();
        middleBranch = new ImageIcon(this.getClass().getResource("/view/tree/middle-branch.png")).getImage();
        trunk = new ImageIcon(this.getClass().getResource("/view/tree/trunk.png")).getImage();
    }

    public void draw(Board board){
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        tree = board.getTree();
        revalidate();
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < tree.size(); i++) {
            if(!tree.get(i).getValue1() && !tree.get(i).getValue2())
                g2d.drawImage(
                        middleBranch,
                        panelWidth / 2 - middleBranch.getWidth(null) / 2,
                        panelHeight - 200 - i * middleBranch.getHeight(null),
                        null
                );
            else if(tree.get(i).getValue1())
                g2d.drawImage(
                        leftBranch,
                        panelWidth / 2 - middleBranch.getWidth(null) / 2,
                        panelHeight - 200 - i * middleBranch.getHeight(null),
                        null
                );
            else if(tree.get(i).getValue2())
                g2d.drawImage(
                        rightBranch,
                        panelWidth / 2 - middleBranch.getWidth(null) / 2,
                        panelHeight - 200 - i * middleBranch.getHeight(null),
                        null
                );

        }
        g2d.drawImage(
                trunk,
                panelWidth / 2 - middleBranch.getWidth(null) / 2,
                panelHeight - 200 + middleBranch.getHeight(null),
                null
                );
    }
}
