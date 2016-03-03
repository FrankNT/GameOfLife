package com.frank.gameoflife;

import android.app.Instrumentation;
import android.graphics.drawable.GradientDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.frank.gameoflife.customview.BoardView;
import com.frank.gameoflife.customview.CellView;
import com.frank.gameoflife.customview.LineView;
import com.frank.gameoflife.customview.ViewHolder;
import com.frank.gameoflife.utils.GameConfig;

import java.util.Random;

/**
 * Created by TrongPhuc on 3/3/16.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainActivity;
    private Instrumentation mInstrumentation;
    private BoardView boardView;
    private Button btnStart;
    private Button btnStop;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mInstrumentation = getInstrumentation();
        mMainActivity = getActivity();
        boardView = (BoardView) mMainActivity.findViewById(R.id.game_view);
        btnStart = (Button) mMainActivity.findViewById(R.id.btn_start);
        btnStop = (Button) mMainActivity.findViewById(R.id.btn_stop);
    }

    public void testStartAndStopButtonsExists() throws Exception {
        View mainActivityDecorView = mMainActivity.getWindow().getDecorView();

        ViewAsserts.assertOnScreen(mainActivityDecorView, btnStart);
        ViewAsserts.assertOnScreen(mainActivityDecorView, btnStop);
        ViewAsserts.assertOnScreen(mainActivityDecorView, boardView);

        assertEquals("Start", btnStart.getText().toString());
        assertEquals("Stop", btnStop.getText().toString());
        assertTrue(btnStart.isClickable());
        assertTrue(btnStart.isClickable());
    }

    public void testDrawBoard() throws Exception {

        assertEquals(boardView.getChildCount(), GameConfig.HEIGHT);

        for (int i = 0; i < boardView.getChildCount(); i++) {
            ViewGroup v = (ViewGroup) boardView.getChildAt(i);
            assertTrue(v instanceof LineView);
            assertEquals(GameConfig.WIDTH, v.getChildCount());
            for (int j = 0; j < v.getChildCount(); j++) {
                View cell = v.getChildAt(j);
                assertTrue(cell instanceof CellView);

                CellView cv = (CellView) cell;
                ViewHolder vh = (ViewHolder) cv.getTag();
                assertEquals(vh.getX(), j);
                assertEquals(vh.getY(), i);
            }
        }
    }

    public void testTouchOnCell() throws Exception {
        MainActivity activity = getActivity();
        final BoardView boardView = (BoardView) activity.findViewById(R.id.game_view);
        Random r = new Random();
        int x = r.nextInt(GameConfig.HEIGHT);
        int y = r.nextInt(GameConfig.WIDTH);

        assertTrue(x < GameConfig.HEIGHT);
        assertTrue(y < GameConfig.WIDTH);

        View v = ((ViewGroup) boardView.getChildAt(x)).getChildAt(y);

        assertTrue(v instanceof CellView);

        TouchUtils.clickView(this, v);
    }
}
