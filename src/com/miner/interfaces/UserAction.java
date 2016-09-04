package com.miner.interfaces;

import com.miner.Constants;

public interface UserAction {
    void initGame();
    void select(int x, int y, Constants.SUGGESTION suggestion);
}
