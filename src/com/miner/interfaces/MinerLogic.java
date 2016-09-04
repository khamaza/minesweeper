package com.miner.interfaces;

import com.miner.Constants;

public interface MinerLogic {
    void loadBoard(Cell[][] cells);
    void suggest(int x, int y, Constants.SUGGESTION suggestion);
    void updateSafetySuggestionNumber();
    int getRowNumber();
    int getColumnNumber();
    int getBombNumber();
    boolean shouldBang(int x, int y);
    boolean finish();
}
