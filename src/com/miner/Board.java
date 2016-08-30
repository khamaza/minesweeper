package com.miner;

public interface Board {
    void setCells(Cell[][] cells);
    void redraw();
    void drawGameOver();
    void drawCongratulate();
}
