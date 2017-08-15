package br.com.antoniogabriel.kata;

import java.util.Arrays;

import static br.com.antoniogabriel.kata.Grid.CellState.DEAD;
import static br.com.antoniogabriel.kata.Grid.CellState.LIVE;


public class Grid {



    enum CellState {
        LIVE("*"), DEAD(".");

        private final String stringValue;

        CellState(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return stringValue;
        }

        static CellState fromString(String str) {
            for (CellState cellState : values()) {
                if(cellState.stringValue.equals(str)) {
                    return cellState;
                }
            }
            throw new IllegalArgumentException("Invalid string:" + str);
        }
    }

    private final CellState[][] grid;
    private final int rows;
    private final int cols;

    public Grid(CellState[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public CellState[][] asCellStateGrid() {
        return grid;
    }

    public int totalRows() {
        return grid.length;
    }

    public int totalCols() {
        return grid[0].length;
    }

    public CellState getCell(int row, int col) {
        return grid[row][col];
    }

    public CellState nextStateForCell(int row, int col) {
        if(isAlive(row, col)) {
            if(liveNeighbours(row, col) < 2 || liveNeighbours(row, col) > 3) {
                return DEAD;
            } else {
                return LIVE;
            }
        } else {
            if(liveNeighbours(row, col) == 3) {
                return LIVE;
            } else {
                return DEAD;
            }
        }
    }

    private int liveNeighbours(int row, int col) {
        int count = 0;

        if(topLeftNeighbourIsAlive(row, col))     count++;
        if(topNeighbourIsAlive(row, col))         count++;
        if(topRightNeighbourIsAlive(row, col))    count++;
        if(rightNeighbourIsAlive(row, col))       count++;
        if(bottomRightNeighbourIsAlive(row, col)) count++;
        if(bottomNeighbourIsAlive(row, col))      count++;
        if(leftBottomNeighbourIsAlive(row, col))  count++;
        if(leftNeighbourIsAlive(row, col))        count++;

        return count;
    }

    private boolean leftNeighbourIsAlive(int row, int col) {
        if(hasLeftNeighbour(col))
            return isAlive(row, col-1);
        return false;
    }

    private boolean leftBottomNeighbourIsAlive(int row, int col) {
        if(hasLeftBottomNeighbour(row, col))
            return isAlive(row+1, col-1);
        return false;
    }

    private boolean bottomNeighbourIsAlive(int row, int col) {
        if(hasBottomNeighbour(row))
            return isAlive(row+1, col);
        return false;
    }

    private boolean bottomRightNeighbourIsAlive(int row, int col) {
        if(hasBottomRightNeighbour(row, col))
            return isAlive(row+1, col+1);
        return false;
    }

    private boolean rightNeighbourIsAlive(int row, int col) {
        if(hasRightNeighbour(col))
            return isAlive(row, col+1);
        return false;
    }

    private boolean topRightNeighbourIsAlive(int row, int col) {
        if(hasTopRightNeighbour(row, col))
            return isAlive(row-1, col+1);
        return false;
    }

    private boolean topNeighbourIsAlive(int row, int col) {
        if(hasTopNeighbour(row))
            return isAlive(row-1, col);
        return false;
    }

    private boolean topLeftNeighbourIsAlive(int row, int col) {
        if(hasTopLeftNeighbour(row, col))
            return isAlive(row-1, col-1);
        return false;
    }

    private boolean hasLeftNeighbour(int col) {
        return col > 0;
    }

    private boolean hasLeftBottomNeighbour(int row, int col) {
        return row < rows-1 && col > 0;
    }

    private boolean hasBottomNeighbour(int row) {
        return row < rows-1;
    }

    private boolean hasBottomRightNeighbour(int row, int col) {
        return row < rows-1 && col < cols-1;
    }

    private boolean hasRightNeighbour(int col) {
        return col < cols-1;
    }

    private boolean hasTopRightNeighbour(int row, int col) {
        return row > 0 && col < cols-1;
    }

    private boolean hasTopNeighbour(int row) {
        return row > 0;
    }

    private boolean hasTopLeftNeighbour(int row, int col) {
        return row > 0 && col > 0;
    }

    private boolean isAlive(int row, int col) {
        return cell(row, col).equals(LIVE);
    }

    private CellState cell(int row, int col) {
        return grid[row][col];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        return Arrays.deepEquals(grid, grid1.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grid);
    }

}
