package br.com.antoniogabriel.kata;

import br.com.antoniogabriel.kata.Grid.CellState;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Paths;

import static br.com.antoniogabriel.kata.Grid.CellState.DEAD;
import static br.com.antoniogabriel.kata.Grid.CellState.LIVE;
import static java.nio.file.Files.deleteIfExists;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private static final String INPUT_FILE = "input.txt";

    private InputReader reader;

    @BeforeClass
    public static void createInputFile() throws Exception {
        FileOps.createFileWithLines(INPUT_FILE,
                                      "........",
                                            "....*...",
                                            "...**...",
                                            "........");
    }

    @AfterClass
    public static void deleteInputFile() throws Exception {
        deleteIfExists(Paths.get(INPUT_FILE));
    }

    @Before
    public void setUp() throws Exception {
        reader = new InputReader(INPUT_FILE);
    }

    @Test
    public void shouldReadInputAsCellStateMatrix() throws Exception {
        CellState[][] matrix = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, LIVE, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, LIVE, LIVE, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };
        assertThat(reader.getGrid(), equalTo(new Grid(matrix)));
    }
}
