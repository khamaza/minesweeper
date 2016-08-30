package com.miner.GUI;

import com.miner.Board;
import com.miner.Cell;

import javax.swing.*;
import java.awt.*;

import static com.miner.Constants.CELL_PADDING;

public class GUIBoard extends JPanel implements Board  {
    public Cell<Graphics>[][] cells;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.cells != null) {
            for (int x=0; x<cells.length; x++) {
                for (int y=0; y<cells[x].length; y++) {
                    g.setColor(Color.black);
                    cells[x][y].draw(g);
                    g.drawRect(x * CELL_PADDING, y * CELL_PADDING, CELL_PADDING, CELL_PADDING);
                }
            }
        }
    }

    @Override
    public void setCells(Cell[][] cells) {
        this.cells = cells;
        this.repaint();
    }

    @Override
    public void redraw() {
        this.repaint();
    }

    @Override
    public void drawGameOver() {
        UIManager.put("OptionPane.okButtonText", "Yes!");

        JOptionPane.showMessageDialog(null, "You lose! Try again?", "Ouch!", JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void drawCongratulate() {
        UIManager.put("OptionPane.okButtonText", "Yes of course!");
        JOptionPane.showMessageDialog(null, "You win! Try again? :)", "Congratulation!", JOptionPane.QUESTION_MESSAGE);
    }
}
