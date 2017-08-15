package br.com.antoniogabriel.kata;

import org.junit.Before;
import org.junit.Test;

import static br.com.antoniogabriel.kata.Grid.CellState.DEAD;
import static br.com.antoniogabriel.kata.Grid.CellState.LIVE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridTest {

    private Grid grid;

    @Before
    public void setUp() throws Exception {
        Grid.CellState[][] matrix = {
                {LIVE, LIVE, DEAD, DEAD},
                {LIVE, LIVE, DEAD, DEAD},
                {DEAD, LIVE, DEAD, LIVE},
                {DEAD, DEAD, DEAD, DEAD}
        };

        grid = new Grid(matrix);
    }

    @Test
    public void livingCellWithLessThanTwoLiveNeighboursShouldDie() throws Exception {
        assertThat(grid.nextStateForCell(3,1), is(DEAD));
    }

    @Test
    public void livingCellWithMoreThanThreeLiveNeighboursShouldDie() throws Exception {
        assertThat(grid.nextStateForCell(1,1), is(DEAD));
    }

    @Test
    public void livingCellWithTwoLiveNeighboursShouldLive() throws Exception {
        assertThat(grid.nextStateForCell(2,1), is(LIVE));
    }

    @Test
    public void livingCellWithThreeLiveNeighboursShouldLive() throws Exception {
        assertThat(grid.nextStateForCell(0,0), is(LIVE));
    }
}