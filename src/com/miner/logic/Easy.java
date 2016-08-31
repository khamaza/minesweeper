package com.miner.logic;

public class Easy extends Common {
    private static final int BOMB_COUNT = 20;
    private static final int COLUMN_COUNT = 10;
    private static final int EASY_GAME = 10;

    @Override
    public int getRowNumber() { return this.EASY_GAME; }

    @Override
    public int getColumnNumber() { return this.COLUMN_COUNT; }

    @Override
    public int getBombNumber() { return this.BOMB_COUNT; }

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
