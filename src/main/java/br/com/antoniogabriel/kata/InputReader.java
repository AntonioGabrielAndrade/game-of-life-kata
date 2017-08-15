package br.com.antoniogabriel.kata;

import br.com.antoniogabriel.kata.Grid.CellState;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.Files.readAllLines;

public class InputReader {

    public static final String CELL_SEPARATOR = "";

    private final CellState[][] grid;

    public InputReader(String inputFile) throws IOException {
        grid = readAllLines(Paths.get(inputFile))
                .stream()
                .map(line -> line.split(CELL_SEPARATOR))
                .map(this::toCellStateArray)
                .toArray(CellState[][]::new);
    }

    private CellState[] toCellStateArray(String[] lineArray) {
        return Arrays.stream(lineArray)
                        .map(this::toCellState)
                        .toArray(CellState[]::new);

    }

    private CellState toCellState(String cell) {
        return CellState.fromString(cell);
    }

    public Grid getGrid() {
        return new Grid(grid);
    }
}
