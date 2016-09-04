package com.miner.impl.GUI;

import com.miner.interfaces.Board;
import com.miner.interfaces.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.miner.Constants.CELL_PADDING;

public class GUIBoard extends JPanel implements Board  {
    public Cell<Graphics>[][] cells;
    HotKeyListener hotKeyListener = null;

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

    public GUIBoard() {
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (hotKeyListener!=null) hotKeyListener.onKeyPressed(e);
            }
        });
    }

    public void setEventListener(HotKeyListener hotKeyListener) {
        this.hotKeyListener = hotKeyListener;
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
