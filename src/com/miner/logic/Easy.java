package com.miner.logic;

import com.miner.Constants;

public class Easy extends Common {
    private static final int BOMB_COUNT = 20;
    private static final int COLUMN_COUNT = 10;
    private static final int EASY_GAME = 10;
    private int safetySuggestionNumber = 3;

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
    public void suggest(int x, int y, Constants.SUGGESTION suggestion) {
        switch (suggestion) {
            case BOMB:
                this.cells[x][y].suggestBomb();
                break;
            case EMPTY:
                if (safetySuggestionNumber > 0)
                {
                    this.makeSuggestionSafety(x, y);
                    safetySuggestionNumber--;
                }
                cells[x][y].suggestEmpty();
                if (!cells[x][y].isBomb()) {
                    cells[x][y].setBombNumberOnAdjacentCells(getBombNumberOnAdjacentCells(x, y));
                }
                break;
            case UNKNOWN:
                cells[x][y].suggestUnknown();
                break;
            default:
                break;
        }
    }
}
