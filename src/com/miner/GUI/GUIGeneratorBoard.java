package com.miner.GUI;

import com.miner.Cell;
import com.miner.GeneratorBoard;

import java.util.Random;

public class GUIGeneratorBoard implements GeneratorBoard{

    @Override
    public Cell[][] generate(int row, int column, int bombNumber) {

        bombNumber = Math.min(row*column, bombNumber);

        GUICell[][] cells = new GUICell[row][column];
        for (int x=0; x<row; x++) {
            for (int y=0; y<column; y++) {
                cells[x][y] = new GUICell(x, y);
            }
        }

        this.fillWithBombs(cells, bombNumber);

        return cells;
    }

    //todo: optimize the algorithm
    private void fillWithBombs(GUICell[][] cells, int bombNumber) {

        Random rnd = new Random();
        int bombsOnBoard=0;

        while (bombsOnBoard<bombNumber) {
            int x = rnd.nextInt(cells.length);
            int y = rnd.nextInt(cells[0].length);

            if (cells[x][y].isBomb()) continue;
            else {
                cells[x][y].markAsBomb();
                bombsOnBoard++;
            }
        }
    }
}
