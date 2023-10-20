
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GameOfLifePanel extends JPanel {
    protected final int GRID_WIDTH = 400; // Width in pixels of the game grid
    protected final int GRID_HEIGHT = 400; // Height in pixels of the game grid
    protected final Color LIVE_COLOR = Color.RED;
    protected final Color DEAD_COLOR = Color.BLACK;
    
    protected class ColorManager {
        private HashMap<Integer, Color> colorInstances = new HashMap<>();
        public Color getColor(int years) {
            Color color = colorInstances.get(years);
            if(color == null) {
                int scale = 180*years/game.LIFE_EXPECTANCY;
                color = new Color(255-scale,0,0);
                colorInstances.put(years, color);
            }
            return color;
        }                
    }
    
    protected GameOfLife game;
    protected int cellHeight;
    protected int cellWidth;
    protected ColorManager colorManager = new ColorManager();
    
    // Build the view of the given game using the given width, height, and color scheme.
    public GameOfLifePanel(GameOfLife world){
        this.game = world;
        this.cellWidth = GRID_WIDTH / world.COLS;
        this.cellHeight = GRID_HEIGHT / world.ROWS;
        initialize();
    }
    // Initialize the UI and build the mouse listener for placing/removing lives
    // from the game.
    protected void initialize(){
        this.setSize(GRID_WIDTH, GRID_HEIGHT);
        this.setPreferredSize(this.getSize());
        this.setBackground(DEAD_COLOR);
        this.setBorder(BorderFactory.createLineBorder(DEAD_COLOR));
        this.addMouseListener( new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                game.toggle(e.getPoint().y / cellHeight, e.getPoint().x / cellWidth);
            }            
        });
    }
    
    // Necessary painting method which draws the lines of the grid and the live cells.
    public void paintComponent(Graphics g){
        super.paintComponent(g); //invokes the paintComponent method from the superclass of JPanel (the JComponent class) to erase whatever is currently drawn on the panel
        drawGrid(g);
        drawLives(g);
    }
    
    // Draws the lines of the grid.
    protected void drawGrid(Graphics g){
        g.setColor(LIVE_COLOR);
        for(int i = 0; i <= game.ROWS; i++){
            g.drawLine(0,i*cellHeight,GRID_WIDTH,i*cellHeight);
        }
        for(int i = 0; i <= game.COLS; i++){
            g.drawLine(i*cellWidth,0,i*cellWidth,GRID_HEIGHT);
        }
    }
    
    // Draws all live cells.
    protected void drawLives(Graphics g){
        for(int i =0; i < game.ROWS; i++){
            for(int j = 0; j < game.COLS; j++){
                if ( game.isAlive(i,j) ){                    
                    g.setColor( colorManager.getColor(game.getYears(i, j)) );
                    g.fillRect(j*cellWidth,i*cellHeight,cellWidth,cellHeight);
                }
            }
        }
    }
    
}
