import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/*
 * 
 * This is the main class of the application. 
 */
public class GameOfLifeUI extends JFrame {
    protected final int PAD_WIDTH = 50;   // Width in pixels to pad around the game display
    protected final int PAD_HEIGHT = 100; // Height in pixels to pad around the game display      

    protected GameOfLife game;
    protected GameOfLifePanel view;
    protected JPanel contentPane;
    protected JButton advanceButton;
    
    
    // Build the appropriate instance of the GameOfLife class and initialize the
    //  application frame.
    public GameOfLifeUI(String title, GameOfLife game)  {        
        super(title);
        this.game = game;
        view = new GameOfLifePanel(game);
        advanceButton = new JButton("Advance");
        contentPane = new JPanel();        
        initialize();
        //game.addObserver(this);        
    }
    
    // Build the UI and set the "advance" button to cause the game object to 
    //  advance one generation.
    protected void initialize(){
        this.setSize(view.getWidth()+PAD_WIDTH, view.getHeight()+PAD_HEIGHT);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(view);
        contentPane.add(advanceButton);
        
        this.setContentPane(contentPane);
        this.setVisible(true);
        advanceButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.advance();
            } } );
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
