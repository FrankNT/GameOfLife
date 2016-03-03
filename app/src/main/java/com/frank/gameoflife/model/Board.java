package com.frank.gameoflife.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class Board implements IBoard {

    private LinkedList<ICell> mList;

    public Board() {
        mList = new LinkedList<>();
    }

    @Override
    public void changeStatus(int x, int y) {
        Cell c = new Cell();
        c.setX(x);
        c.setY(y);
        if (mList.contains(c)) {
            mList.remove(c);
        } else {
            mList.add(c);
        }
    }

    @Override
    public ICell get(int x, int y) {
        Cell c = new Cell();
        c.setX(x);
        c.setY(y);
        if (mList.contains(c)) return  c;
        return null;
    }

    @Override
    public ICell get(int pos) {
        if (mList == null) return null;
        return mList.get(pos);
    }

    @Override
    public boolean isAllDie() {
        return (mList == null || mList.isEmpty());
    }

    @Override
    public int size() {
        if (mList == null) return 0;
        return mList.size();
    }

    @Override
    public boolean contains(ICell c) {
        return mList != null && mList.contains(c);
    }

    @Override
    public void add(ICell c) {
        if (mList != null) {
            mList.add(c);
        }
    }

    @Override
    public void remove(ICell c) {
        if (mList != null) {
            mList.remove(c);
        }
    }

    @Override
    public List<ICell> getAllList() {
        return mList;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Board)) return false;
        IBoard b = (Board)o;
        return b.getAllList().containsAll(mList) && mList.containsAll(b.getAllList());
    }
}
