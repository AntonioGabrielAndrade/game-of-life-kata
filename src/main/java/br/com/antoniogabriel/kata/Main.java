package br.com.antoniogabriel.kata;

public class Main {

    private static final String INPUT_FILE;

    static {
        INPUT_FILE = Main.class.getClassLoader().getResource("blinker.txt").getFile();
//        INPUT_FILE = Main.class.getClassLoader().getResource("beacon.txt").getFile();
    }

    public static void main(String[] args) throws InterruptedException {
        Console console = new Console();
        GameOfLife game = new GameOfLife(console);

        game.start(INPUT_FILE);

        while(true) {
            Thread.sleep(1000);
            game.nextGeneration();
        }
    }
}
