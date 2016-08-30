package com.miner;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Cell<T> {
    boolean isBomb();
    boolean isSuggestBomb();
    boolean isSuggestEmpty();
    void setBombNumberOnAdjacentCells(int number);
    void markAsBomb();
    void suggestBomb();
    void suggestEmpty();
    void draw(T paint);
}
