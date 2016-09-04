package com.miner.interfaces;

public interface Board {
    void setCells(Cell[][] cells);
    void redraw();
    void drawGameOver();
    void drawCongratulate();
}
