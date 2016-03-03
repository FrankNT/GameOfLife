package com.frank.gameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.frank.gameoflife.presenter.GamePresenter;
import com.frank.gameoflife.presenter.IGamePresenter;
import com.frank.gameoflife.utils.GameConfig;
import com.frank.gameoflife.view.GameView;
import com.frank.gameoflife.view.IGameView;

public class MainActivity extends AppCompatActivity {

    private IGamePresenter gamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IGameView gameView = new GameView(this);
        gamePresenter = new GamePresenter(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gamePresenter.handleResume();
    }
}
