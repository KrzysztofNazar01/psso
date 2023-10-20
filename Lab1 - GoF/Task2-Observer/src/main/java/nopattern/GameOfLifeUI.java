package nopattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GameOfLifeUI extends JFrame implements Observer {

    protected JButton advanceButton;
    protected JPanel contentPane;
    protected final static int WIDTH_PAD = 50;
    protected final static int HEIGHT_PAD = 100;
    protected GameOfLifeApp game;
    protected GameOfLifePanel view;

    public GameOfLifeUI(String title, GameOfLifeApp game){
        super(title);
        advanceButton = new JButton("Advance");
        contentPane = new JPanel();
        this.game = game;
        this.view = new GameOfLifePanel(game);
        initialize();
    }

    // Build the UI and set the "advance" button to cause the game object to
    //  advance one generation.
    protected void initialize(){
        this.setSize(view.getWidth()+WIDTH_PAD, view.getHeight()+HEIGHT_PAD);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(view);
        contentPane.add(advanceButton);
        this.setContentPane(contentPane);
        this.setVisible(true);
        advanceButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.advance();
            } } );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable obs, Object obj) {
        view.repaint();
    }
}
