package com.miner;

public interface MinerLogic {
    void loadBoard(Cell[][] cells);
    void suggest(int x, int y, Constants.SUGGESTION suggestion);
    void updateSafetySuggestionNumber();
    int getBombNumberOnAdjacentCells(int x, int y);
    int getRowNumber();
    int getColumnNumber();
    int getBombNumber();
    boolean shouldBang(int x, int y);
    boolean finish();
}
