package com.frank.gameoflife.view;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public interface OnViewListener {
    void onBtnStartClicked();

    void onBtnStopClicked();

    void onCellClicked(int x, int y);
}
