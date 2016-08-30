package com.miner;

public interface UserAction {
    void initGame();
    void select(int x, int y, Constants.SUGGESTION suggestion);
}
