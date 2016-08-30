package com.miner.GUI;

import com.miner.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

import static com.miner.Constants.CELL_PADDING;

public class GUICell implements Cell<Graphics> {

    private int coordX=-1;
    private int coordY=-1;
    private boolean isSuggestedBomb = false;
    private boolean isSuggestedEmpty = false;
    private boolean isBomb = false;
    private int bombNumberOnAdjacentCells=-1;

    public GUICell(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public boolean isBomb() {
        return isBomb;
    }

    @Override
    public void markAsBomb() {
        this.isBomb =true;
    }

    @Override
    public boolean isSuggestBomb() {
        return isSuggestedBomb;
    }

    @Override
    public boolean isSuggestEmpty() {
        return isSuggestedEmpty;
    }

    @Override
    public void setBombNumberOnAdjacentCells(int number) {
        this.bombNumberOnAdjacentCells = number;
    }

    @Override
    public void suggestBomb() {
        if (!this.isSuggestEmpty())
            this.isSuggestedBomb = true;
    }

    @Override
    public void suggestEmpty() {
        this.isSuggestedBomb = false;
        this.isSuggestedEmpty = true;
    }

    @Override
    public void draw(Graphics paint) {
        if (this.isSuggestedBomb) {
            Image image = new ImageIcon(this.getClass().getResource("/com/miner/GUI/drawable/flag.png")).getImage();

            paint.drawImage(image, 1+coordX*CELL_PADDING, 1+coordY*CELL_PADDING, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoFlags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }

        if (this.isSuggestedEmpty && !this.isBomb()) {
            Image image = new ImageIcon(this.getClass().getResource("/com/miner/GUI/drawable/empty.png")).getImage();

            paint.drawImage(image, 1+coordX*CELL_PADDING, 1+coordY*CELL_PADDING, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoFlags, int x, int y, int width, int height) {
                    return false;
                }
            });

            int fontSizeX=10;
            int fontSizeY=20;
            paint.drawString(String.valueOf(this.bombNumberOnAdjacentCells), fontSizeX+coordX*CELL_PADDING, fontSizeY+coordY*CELL_PADDING);
        }

        if (this.isSuggestedEmpty && this.isBomb())
        {
            Image image = new ImageIcon(this.getClass().getResource("/com/miner/GUI/drawable/bang.png")).getImage();

            paint.drawImage(image, 1+coordX*25, 1+coordY*25, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoFlags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}
