package com.miner.logic;

import com.miner.Constants;

public class Easy extends BaseLogic {
    private static final int BOMB_COUNT = 20;
    private static final int COLUMN_COUNT = 10;
    private static final int EASY_GAME = 10;
    private int safetySuggestionNumber;

    @Override
    public int getRowNumber() { return this.EASY_GAME; }

    @Override
    public int getColumnNumber() { return this.COLUMN_COUNT; }

    @Override
    public int getBombNumber() { return this.BOMB_COUNT; }

    @Override
    public void updateSafetySuggestionNumber() {
        this.safetySuggestionNumber = 3;
    }

    @Override
    public boolean shouldBang(int x, int y) {
        if (this.cells[x][y].isBomb() && this.cells[x][y].isSuggestEmpty())
            return true;
        else return false;
    }
}
