
package nopattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
/*
 * This class represents both the Life game and the UI of that game.
 */
public class GameOfLifePanel extends JPanel {
    protected int cellHeight;
    protected int cellWidth;
    protected final int GRID_HEIGHT = 400;
    protected final int GRID_WIDTH = 400;
    protected final Color DEAD_COLOR = Color.black;
    protected final Color LIVE_COLOR = Color.red;
    protected GameOfLifeApp game;

    public GameOfLifePanel(GameOfLifeApp  game){
        this.cellWidth = GRID_WIDTH / game.COLS;
        this.cellHeight = GRID_HEIGHT / game.ROWS;
        this.game = game;
        initialize();
    }

    protected void initialize(){
        // Set the size of the Panel to  the Width x Height
        this.setSize(GRID_WIDTH, GRID_HEIGHT);
        this.setPreferredSize(this.getSize());
        this.setBackground(DEAD_COLOR);

        // Add a listener to the mouse that will cause the life at the x,y
        //  position of the grid to be turned on/off.
        this.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mousePressed(MouseEvent e) {
                game.toggle(e.getPoint().y / cellHeight, e.getPoint().x / cellWidth);
            }
            public void mouseReleased(MouseEvent e) {
            }});
    }

    // Necessary painting method which draws the lines of the grid and the live cells.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        drawLives(g);
    }

    // Draws the lines of the grid.
    protected void drawGrid(Graphics g){
        int cellSize = this.getHeight() / game.ROWS;
        g.setColor(Color.red);
        for(int i = 1; i < game.COLS; i++){
            g.drawLine(0,i*cellSize,this.getWidth(),i*cellSize);
        }
        cellSize = this.getWidth() / game.COLS;
        for(int i = 1; i < game.COLS; i++){
            g.drawLine(i*cellSize,0,i*cellSize,this.getHeight());
        }
    }

    // Draws all live cells.
    protected void drawLives(Graphics g){
        g.setColor(LIVE_COLOR);
        for(int i =0; i < game.ROWS; i++){
            for(int j = 0; j < game.COLS; j++){
                if ( game.isAlive(i,j) ){
                    g.fillRect(j*cellWidth,i*cellHeight,cellWidth,cellHeight);
                }
            }
        }
    }
}
