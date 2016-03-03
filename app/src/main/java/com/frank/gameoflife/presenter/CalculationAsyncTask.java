package com.frank.gameoflife.presenter;

import android.os.AsyncTask;

import com.frank.gameoflife.model.Board;
import com.frank.gameoflife.model.Cell;
import com.frank.gameoflife.model.IBoard;
import com.frank.gameoflife.model.ICell;
import com.frank.gameoflife.utils.Utils;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class CalculationAsyncTask extends AsyncTask<IBoard, Void, IBoard>{

    private CalcListener mListener;

    public CalculationAsyncTask(CalcListener calcListener) {
        mListener = calcListener;
    }

    @Override
    protected IBoard doInBackground(IBoard... params) {
        Utils.sleep();
        IBoard status = params[0];
        return getNextGeneration(status);
    }

    public IBoard getNextGeneration(IBoard board) {
        IBoard result = new Board();
        for (int i = 0; i < board.size(); i++) {
            // Alive cell will die or not
            ICell c = board.get(i);
            int noLiveNeighbours = countLiveNeighbours(c, board);
            if (noLiveNeighbours >= 2 && noLiveNeighbours <= 3) {
                // continue to live
                if (!result.contains(c)) {
                    result.add(c);
                }
            } else {
                // die
                if (result.contains(c)) {
                    result.remove(c);
                }
            }
            // Dead cell will live or not
            for (int x = c.getX() - 1; x <= c.getX() + 1; x++) {
                for (int y = c.getY() - 1; y <= c.getY() + 1; y++) {
                    if (board.get(x, y) != null || result.get(x, y) != null) continue;
                    ICell tmp = new Cell();
                    tmp.setX(x);
                    tmp.setY(y);
                    int noLive = countLiveNeighbours(tmp, board);
                    if (noLive == 3) {
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    public int countLiveNeighbours(ICell c, IBoard board) {
        int count = 0;
        for (int i = c.getX() - 1; i <= c.getX() + 1; i++) {
            for (int j = c.getY() - 1; j <= c.getY() + 1; j++) {
                if (i == c.getX() && j == c.getY()) continue;
                if (board.get(i, j) != null) count++;
            }
        }
        return count;
    }

    @Override
    protected void onPostExecute(IBoard iGameStatus) {
        super.onPostExecute(iGameStatus);
        if (mListener != null) {
            mListener.onResult(iGameStatus);
        }
    }
}
