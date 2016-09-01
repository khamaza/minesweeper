package com.miner;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Cell<T> {
    boolean isBomb();
    boolean isSuggestBomb();
    boolean isSuggestEmpty();
    void setBombNumberOnAdjacentCells(int number);
    void markAsBomb();
    void markAsEmpty();
    void suggestBomb();
    void suggestEmpty();
    void suggestUnknown();
    void draw(T paint);
}
