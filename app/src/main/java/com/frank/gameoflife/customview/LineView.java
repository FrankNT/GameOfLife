package com.frank.gameoflife.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.frank.gameoflife.view.OnCellClickListener;

/**
 * Created by TrongPhuc on 2/28/16.
 */
public class LineView extends LinearLayout {
    private int mColumn;
    private OnCellClickListener mListener;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private void init(int no, final int y) {
        for (int i = 0; i < no; i++) {
            CellView cv = new CellView(getContext());
            final int finalI = i;
            cv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onCellClicked(finalI,y);
                    }
                }
            });
            cv.setTag(new ViewHolder(i, y));
            LayoutParams params = new LinearLayout.LayoutParams(
                    0,
                    LayoutParams.WRAP_CONTENT, 1.0f);
            params.setMargins(1,1,1,1);
            this.addView(cv, params);
        }
    }

    public void setColumn(int column, int y) {
        this.mColumn = column;
        this.removeAllViews();
        init(mColumn, y);
        invalidate();
    }

    public void setOnClickListener(OnCellClickListener mListener) {
        this.mListener = mListener;
    }
}
