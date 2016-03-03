package com.frank.gameoflife.view;

import com.frank.gameoflife.model.IBoard;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public interface IGameView {
    void setOnViewListener(OnViewListener listener);

    IBoard getGameState();

    void showGame(IBoard mGameStatus);

    void init(int width, int height);

    void showWarningToast();
}
