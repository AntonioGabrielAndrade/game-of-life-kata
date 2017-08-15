package br.com.antoniogabriel.kata;

import java.io.IOException;

public class GameOfLife {

    private Console console;
    private Grid grid;
    private int generation = 0;

    public GameOfLife(Console console) {
        this.console = console;
    }

    public void start(String inputFile) {
        try {
            next(new InputReader(inputFile).getGrid());
        } catch (IOException e) {
            console.printLine("Could not read file: " + inputFile);
        }
    }

    public void nextGeneration() {
        next(grid.nextGeneration());
    }

    private void next(Grid nextGrid) {
        generation++;
        grid = nextGrid;
        printGeneration(generation, grid);
    }

    private void printGeneration(int generation, Grid grid) {
        printHeader(generation, grid);
        printGrid(grid);
    }

    private void printHeader(int generation, Grid grid) {
        console.printLine("Generation " + generation + ":");
        console.printLine(grid.totalRows() + " " + grid.totalCols());
    }

    private void printGrid(Grid grid) {
        for (int row = 0; row < grid.totalRows(); row++) {
            console.printLine(buildLineFrom(row, grid));
        }
    }

    private String buildLineFrom(int row, Grid grid) {
        String line = "";
        for (int col = 0; col < grid.totalCols(); col++) {
            line += grid.getCell(row, col).toString();
        }
        return line;
    }

}
