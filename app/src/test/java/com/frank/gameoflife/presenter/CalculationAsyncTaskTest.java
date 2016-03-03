package com.frank.gameoflife.presenter;

import com.frank.gameoflife.model.Board;
import com.frank.gameoflife.model.Cell;
import com.frank.gameoflife.model.IBoard;
import com.frank.gameoflife.model.ICell;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TrongPhuc on 3/2/16.
 */
public class CalculationAsyncTaskTest {

    private CalculationAsyncTask calculationAsyncTask;
    private CalcListener mListener;

    @Before
    public void setUp() throws Exception {
        calculationAsyncTask = new CalculationAsyncTask(mListener);
    }

    @Test
    public void testCountLiveNeighbours() throws Exception {
        ICell c = new Cell();
        c.setX(1);
        c.setY(1);

        IBoard board = new Board();

        assertEquals(0, calculationAsyncTask.countLiveNeighbours(c, board));

        ICell c1 = new Cell();
        c1.setX(1);
        c1.setY(1);
        board.add(c1);

        ICell c2 = new Cell();
        c2.setX(2);
        c2.setY(2);
        board.add(c2);

        assertEquals(1, calculationAsyncTask.countLiveNeighbours(c, board));

        ICell c3 = new Cell();
        c3.setX(1);
        c3.setY(2);
        board.add(c3);

        ICell c4 = new Cell();
        c4.setX(2);
        c4.setY(1);
        board.add(c4);

        assertEquals(3, calculationAsyncTask.countLiveNeighbours(c, board));

        ICell c5 = new Cell();
        c5.setX(10);
        c5.setY(10);

        assertEquals(0, calculationAsyncTask.countLiveNeighbours(c5, board));
    }

    @Test
    public void testGetNextGeneration() throws Exception {
        IBoard board = new Board();
        ICell c1 = new Cell();
        c1.setX(1);
        c1.setY(1);
        board.add(c1);
        ICell c2 = new Cell();
        c2.setX(2);
        c2.setY(2);
        board.add(c2);
        ICell c3 = new Cell();
        c3.setX(1);
        c3.setY(2);
        board.add(c3);
        ICell c4 = new Cell();
        c4.setX(2);
        c4.setY(1);
        board.add(c4);

        IBoard expectedResult = new Board();
        ICell c11 = new Cell();
        c11.setX(1);
        c11.setY(1);
        expectedResult.add(c11);
        ICell c12 = new Cell();
        c12.setX(2);
        c12.setY(2);
        expectedResult.add(c12);
        ICell c13 = new Cell();
        c13.setX(1);
        c13.setY(2);
        expectedResult.add(c13);
        ICell c14 = new Cell();
        c14.setX(2);
        c14.setY(1);
        expectedResult.add(c14);

        IBoard realResult = calculationAsyncTask.getNextGeneration(board);
        assertEquals(expectedResult, realResult);
    }

    @Test
    public void testGetNextGeneration_case2() throws Exception {
        IBoard board = new Board();
        ICell c1 = new Cell();
        c1.setX(1);
        c1.setY(1);
        board.add(c1);

        assertEquals(new Board(), calculationAsyncTask.getNextGeneration(board));
    }
}