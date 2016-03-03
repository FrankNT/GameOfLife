package com.frank.gameoflife.customview;

/**
 * Created by TrongPhuc on 2/29/16.
 */
public class ViewHolder {
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public ViewHolder(int i, int y) {
        this.x = i;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
