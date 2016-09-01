package com.miner.logic;

import com.miner.Cell;
import com.miner.MinerLogic;

public abstract class Common implements MinerLogic {
    protected Cell[][] cells;

    @Override
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
        this.updateSafetySuggestionNumber();
    }

    public int getBombNumberOnAdjacentCells(int x, int y) {

        int counter=0;

        if (x-1 >= 0)
        {
            if (y-1 >= 0 && cells[x-1][y-1].isBomb()) counter++;
            if (cells[x-1][y].isBomb()) counter++;
            if (y+1 < cells[x].length && cells[x-1][y+1].isBomb()) counter++;
        }

        if (y-1 >= 0 && cells[x][y-1].isBomb()) counter++;
        if (y+1 < cells[x].length && cells[x][y+1].isBomb()) counter++;

        if (x+1 < cells.length)
        {
            if (y-1 >= 0 && cells[x+1][y-1].isBomb()) counter++;
            if (cells[x+1][y].isBomb()) counter++;
            if (y+1 < cells[x+1].length && cells[x+1][y+1].isBomb()) counter++;
        }

        return counter;
    }

    @Override
    public boolean finish() {
        for (int x=0; x<cells.length; x++) {
            for (int y=0; y<cells[0].length; y++) {
                if ((cells[x][y].isBomb() && cells[x][y].isSuggestBomb()) ||
                        !cells[x][y].isBomb() && cells[x][y].isSuggestEmpty())
                    continue;
                else return false;
            }
        }
        return true;
    }

    protected final void makeSuggestionSafety(int x, int y) {
        if (!cells[x][y].isBomb()) return;

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[i].length; j++) {
                if (!cells[i][j].isBomb() && !cells[i][j].isSuggestEmpty())
                {
                    cells[i][j].markAsBomb();
                    cells[x][y].markAsEmpty();
                    return;
                }
            }
        }
    }
}
