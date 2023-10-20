/*
 * This class invokes the game of life for a given number of cells (row x col) and specifies
 * a user interface to be used by the game.  The user interface takes the colors for dead and
 * alive cells.
 */
public class Main {
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife(20, 20, 10);
		GameOfLifeUI life = new GameOfLifeUI("The Game of Life",game);
	}
}
