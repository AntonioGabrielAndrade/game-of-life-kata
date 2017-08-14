package br.com.antoniogabriel.kata;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.*;
import static java.nio.file.StandardOpenOption.APPEND;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

    private static final String INPUT_FILE = "input.txt";

    private InputReader reader;

    @BeforeClass
    public static void createInputFile() throws Exception {
        createFileWithLines(INPUT_FILE,
                                      "........",
                                            "....*...",
                                            "...**...",
                                            "........");
    }

    @AfterClass
    public static void deleteInputFile() throws Exception {
        deleteIfExists(Paths.get(INPUT_FILE));
    }

    private static void createFileWithLines(String inputFile, String... lines) throws IOException {
        createFile(Paths.get(inputFile));
        for (String line : lines) {
            writeLine(INPUT_FILE, line);
        }
    }

    private static void writeLine(String inputFile, String line) throws IOException {
        write(Paths.get(inputFile), (line + "\n").getBytes(), APPEND);
    }

    @Before
    public void setUp() throws Exception {
        reader = new InputReader(INPUT_FILE);
    }

    @Test
    public void shouldReadInputAsBooleanMatrix() throws Exception {
        Boolean[][] matrix = {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, true,  false, false, false},
                {false, false, false, true,  true,  false, false, false},
                {false, false, false, false, false, false, false, false}
        };
        assertThat(reader.getGrid(), equalTo(matrix));
    }
}
