package br.com.antoniogabriel.kata;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.Files.readAllLines;

public class InputReader {

    public static final String DEAD = ".";
    public static final String LIVE = "*";
    public static final String CELL_SEPARATOR = " ";

    private final Boolean[][] grid;

    public InputReader(String inputFile) throws IOException {
        grid = readAllLines(Paths.get(inputFile))
                .stream()
                .map(line -> line.split(CELL_SEPARATOR))
                .map(this::toBooleanArray)
                .toArray(Boolean[][]::new);
    }

    private Boolean[] toBooleanArray(String[] lineArray) {
        return Arrays.stream(lineArray)
                        .map(this::toBoolean)
                        .toArray(Boolean[]::new);

    }

    private boolean toBoolean(String cell) {
        switch (cell) {
            case DEAD:
                return false;
            case LIVE:
                return true;
            default:
                throw new IllegalArgumentException("Unknown grid cell: " + cell);
        }
    }

    public Boolean[][] getGrid() {
        return grid;
    }
}
