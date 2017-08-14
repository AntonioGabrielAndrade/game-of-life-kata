package br.com.antoniogabriel.kata;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.write;
import static java.nio.file.StandardOpenOption.APPEND;

public class FileOps {

    public static void createFileWithLines(String inputFile, String... lines) throws IOException {
        createFile(Paths.get(inputFile));
        for (String line : lines) {
            writeLine(inputFile, line);
        }
    }

    public static void writeLine(String inputFile, String line) throws IOException {
        write(Paths.get(inputFile), (line + "\n").getBytes(), APPEND);
    }
}
