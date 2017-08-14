package br.com.antoniogabriel.kata;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.nio.file.Paths;

import static java.nio.file.Files.deleteIfExists;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class GameOfLifeTest {

    private static final String INPUT_FILE = "input.txt";

    @Mock Console console;

    private GameOfLife game;

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
        game = new GameOfLife(console);
    }

    @Test
    public void shouldPrintInputGrid() throws Exception {
        game.start(INPUT_FILE);

        InOrder inOrder = inOrder(console);

        inOrder.verify(console).printLine("Generation 1:");
        inOrder.verify(console).printLine("4 8");
        inOrder.verify(console).printLine("........");
        inOrder.verify(console).printLine("....*...");
        inOrder.verify(console).printLine("...**...");
        inOrder.verify(console).printLine("........");
    }
}
