package com.frank.gameoflife.presenter;

import com.frank.gameoflife.model.Board;
import com.frank.gameoflife.model.IBoard;
import com.frank.gameoflife.utils.GameConfig;
import com.frank.gameoflife.view.IGameView;
import com.frank.gameoflife.view.OnViewListener;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class GamePresenter implements IGamePresenter, OnViewListener, CalcListener {

    private IGameView mView;
    private IBoard mGameStatus = new Board();
    private boolean isRunning;

    public GamePresenter(IGameView gameView) {
        init(gameView);
    }

    public void init(IGameView gameView) {
        mView = gameView;
        mView.init(GameConfig.WIDTH, GameConfig.HEIGHT);
        mView.setOnViewListener(this);
    }

    @Override
    public void onBtnStartClicked() {
        if (isRunning) return;
        mGameStatus = mView.getGameState();
        isRunning = true;
        new CalculationAsyncTask(this).execute(mGameStatus);
    }

    @Override
    public void onBtnStopClicked() {
        isRunning = false;
    }

    @Override
    public void onCellClicked(int x, int y) {
        if (isRunning) {
            mView.showWarningToast();
            return;
        }
        mGameStatus.changeStatus(x, y);
        mView.showGame(mGameStatus);
    }

    @Override
    public void onResult(IBoard result) {
        mGameStatus = result;
        mView.showGame(mGameStatus);
        if (isRunning) {
            if (mGameStatus.isAllDie()) {
                isRunning = false;
            } else {
                new CalculationAsyncTask(GamePresenter.this).execute(mGameStatus);
            }
        }
    }

    @Override
    public void handleResume() {

    }
}
