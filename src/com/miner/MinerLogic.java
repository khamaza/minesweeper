package com.miner;

public interface MinerLogic {
    void loadBoard(Cell[][] cells);
    void suggest(int x, int y, Constants.SUGGESTION suggestion);
    int getBombNumberOnAdjacentCells(int x, int y);
    boolean shouldBang(int x, int y);
    boolean finish();
}
