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

    private void printGeneration(int generation, Boolean[][] grid) {
        printHeader(generation, grid);
        printGrid(grid);
    }

    private void printHeader(int generation, Boolean[][] grid) {
        console.printLine("Generation " + generation + ":");
        console.printLine(grid.length + " " + grid[0].length);
    }

    private void printGrid(Boolean[][] grid) {
        for (Boolean[] row : grid) {
            console.printLine(buildLineFrom(row));
        }
    }

    private String buildLineFrom(Boolean[] row) {
        String line = "";
        for (int i = 0; i < row.length; i++) {
            line += asString(row[i]);
        }
        return line;
    }

    private String asString(Boolean cell) {
        return cell ? "*" : ".";
    }
}
