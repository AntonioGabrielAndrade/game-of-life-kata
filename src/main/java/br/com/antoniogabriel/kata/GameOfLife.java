package br.com.antoniogabriel.kata;

import java.io.IOException;

public class GameOfLife {

    private Console console;

    public GameOfLife(Console console) {
        this.console = console;
    }

    public void start(String inputFile) {
        try {
            printGeneration(1, new InputReader(inputFile).getGrid());
        } catch (IOException e) {
            console.printLine("Could not read file: " + inputFile);
        }
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
