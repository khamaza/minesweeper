package com.miner.logic;

import com.miner.Cell;
import com.miner.Constants;
import com.miner.MinerLogic;

public class Easy extends Common {

    @Override
    public boolean shouldBang(int x, int y) {
        if (this.cells[x][y].isBomb() && this.cells[x][y].isSuggestEmpty())
            return true;
        else return false;
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
}
