package br.com.antoniogabriel.kata;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Paths;

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
