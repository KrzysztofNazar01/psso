
/*
 * 
 * This class represents the Life game 
 */
public class GameOfLife {//extends java.util.Observable {
    public final int ROWS;
    public final int COLS;
    public final int LIFE_EXPECTANCY;
    protected int grid[][];
    
    public GameOfLife(int rows, int cols, int lifeExpectancy){
        this.ROWS = rows;
        this.COLS = cols;
        this.LIFE_EXPECTANCY = lifeExpectancy;
        grid = new int[rows][cols];
    }
    
    // Return true if the cell at r,c is alive.
    public boolean isAlive(int r, int c){
        return (grid[r][c] != 0);
    }
    public int getYears(int r, int c){
        return LIFE_EXPECTANCY-grid[r][c];
    }
    // Reverse the life status of the cell at location r,c
    public void toggle(int r, int c){
        if( isAlive(r,c) ) grid[r][c] = 0;
        else grid[r][c] = LIFE_EXPECTANCY;        
        //setChanged();
        //notifyObservers();
    }
    
    // Returns the number of alive neighbors for the cell at position r,c.  The
    //  grid is finite but unbound, meaning that the neighbor relation wraps around
    //  the grid boundaries.
    protected int nbrOfNeighbors(int r, int c){
        int n = 0;
        int x = 0;
        int y = r-1;
        if ( y < 0 ) y = ROWS-1; 
        for (int rCt = 1; rCt <= 3; rCt++) {
            x = c-1;
            if ( x < 0 ) x = COLS-1;
            for(int cCt = 1; cCt <= 3; cCt++){
                if ( x != c || y != r ) {
                    if (  isAlive(y,x) ) n++;
                }
                x = (x+1) % COLS;
            }
            y = (y+1)%ROWS;
        }
        return n;
    }
    
    // This method implements the rules of the Game of Life.  For each cell,
    //  we simple find the number of neighbors and then bring the cell to life
    //  if appropriate. 
    public void advance(){
        int[][] newGrid = new int[ROWS][COLS];
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                int n = nbrOfNeighbors(i,j);
                if ( isAlive(i,j) ) {
                    if (n == 2 || n == 3) newGrid[i][j] = grid[i][j] - 1;                    
                    else newGrid[i][j] = 0;                    
                } else {
                    if (n == 3) newGrid[i][j] = LIFE_EXPECTANCY;                    
                    else newGrid[i][j] = 0;
                }                
            }
        }
        grid = newGrid;
        //setChanged();
        //notifyObservers();
    }

}
