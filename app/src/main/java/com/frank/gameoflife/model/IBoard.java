package com.frank.gameoflife.model;

import java.util.List;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public interface IBoard {
    void changeStatus(int x, int y);

    ICell get(int x, int y);

    ICell get(int pos);

    boolean isAllDie();

    int size();

    boolean contains(ICell c);

    void add(ICell c);

    void remove(ICell c);

    List<ICell> getAllList();
}
