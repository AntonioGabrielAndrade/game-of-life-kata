package br.com.antoniogabriel.kata;

import java.io.IOException;

public class GameOfLife {

    private Console console;
    private Grid grid;
    private int generation;

    public GameOfLife(Console console) {
        this.console = console;
    }

    public void start(String inputFile) {
        try {
            grid = new InputReader(inputFile).getGrid();
            generation = 1;
            printGeneration(generation, grid);
        } catch (IOException e) {
            console.printLine("Could not read file: " + inputFile);
        }
    }

    public void nextGeneration() {
        generation++;
        grid = grid.nextGeneration();
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
        for (int i = 0; i < grid.totalRows(); i++) {
            console.printLine(buildLineFrom(i, grid));
        }
    }

    private String buildLineFrom(int row, Grid grid) {
        String line = "";
        for (int i = 0; i < grid.totalCols(); i++) {
            line += grid.getCell(row, i).toString();
        }
        return line;
    }

}
