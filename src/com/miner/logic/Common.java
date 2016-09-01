package com.miner.logic;

import com.miner.Cell;
import com.miner.MinerLogic;

public abstract class Common implements MinerLogic {
    protected Cell[][] cells;

    @Override
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
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
}
