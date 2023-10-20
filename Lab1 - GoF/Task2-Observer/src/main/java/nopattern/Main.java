package nopattern;

/*
 * The main program used to invoke the game of life system.
 */

public class Main {

    public static void main(String[] args) {
        // Create an instance of the game with a 20x20 life grid shown in a 200x200 panel.
        GameOfLifeApp life = new GameOfLifeApp(20, 20, 10);
        GameOfLifeUI ui = new GameOfLifeUI("The Game of Life", life);
        life.addObserver(ui);
    }
}

