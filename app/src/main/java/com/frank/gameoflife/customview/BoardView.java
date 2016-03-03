package com.frank.gameoflife.customview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.frank.gameoflife.R;
import com.frank.gameoflife.model.Cell;
import com.frank.gameoflife.model.IBoard;
import com.frank.gameoflife.view.OnCellClickListener;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class BoardView extends LinearLayout {
    private OnCellClickListener mListener;
    private IBoard gameState;

    public BoardView(Context context) {
        super(context);
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        this.mListener = onCellClickListener;
    }

    public IBoard getGameState() {
        return gameState;
    }

    public void setGameState(IBoard gameState) {
        this.gameState = gameState;
        for (int i = 0; i < this.getChildCount(); i++) {
            LineView lineView = (LineView)this.getChildAt(i);
            for (int j = 0; j < lineView.getChildCount(); j++) {
                CellView cellView = (CellView)lineView.getChildAt(j);
                ViewHolder vh = (ViewHolder)cellView.getTag();
                Cell cell = (Cell) gameState.get(vh.getX(), vh.getY());
                if (cell != null) {
                    ((GradientDrawable) cellView.getBackground()).setColor(getResources().getColor(R.color.colorPrimaryDark));
                } else {
                    ((GradientDrawable) cellView.getBackground()).setColor(getResources().getColor(android.R.color.white));
                }
            }
        }
    }

    public void init(int mWidth, int mHeight) {
        for (int i = 0; i < mHeight; i ++) {
            LineView lv = new LineView(getContext());
            lv.setColumn(mWidth, i);
            lv.setOnClickListener(mListener);
            LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT);
            this.addView(lv, params);
        }
    }
}
