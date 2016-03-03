package com.frank.gameoflife.model;

import java.util.List;

/**
 * Created by TrongPhuc on 2/26/16.
 */

public class Cell implements ICell {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell)) return false;
        Cell c2 = (Cell)o;
        return this.x == c2.getX() && this.y == c2.getY();
    }
}
