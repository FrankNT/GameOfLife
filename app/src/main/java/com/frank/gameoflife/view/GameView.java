package com.frank.gameoflife.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.frank.gameoflife.MainActivity;
import com.frank.gameoflife.R;
import com.frank.gameoflife.customview.BoardView;
import com.frank.gameoflife.model.IBoard;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class GameView implements IGameView, View.OnClickListener, OnCellClickListener {

    private final Context mContext;
    private BoardView customView;
    private OnViewListener mListener;

    public GameView(Activity activity) {
        mContext = activity;
        Button btnStart = (Button) activity.findViewById(R.id.btn_start);
        Button btnStop = (Button) activity.findViewById(R.id.btn_stop);
        customView = (BoardView) activity.findViewById(R.id.game_view);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        customView.setOnCellClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                if (mListener != null) {
                    mListener.onBtnStartClicked();
                }
                break;
            case R.id.btn_stop:
                if (mListener != null) {
                    mListener.onBtnStopClicked();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void setOnViewListener(OnViewListener listener) {
        mListener = listener;
    }

    @Override
    public IBoard getGameState() {
        return customView.getGameState();
    }

    @Override
    public void showGame(IBoard mGameStatus) {
        customView.setGameState(mGameStatus);
    }

    @Override
    public void init(int width, int height) {
        customView.init(width, height);
    }

    @Override
    public void showWarningToast() {
        Toast.makeText(mContext, R.string.warning, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCellClicked(int x, int y) {
        if (mListener != null) {
            mListener.onCellClicked(x, y);
        }
    }
}
