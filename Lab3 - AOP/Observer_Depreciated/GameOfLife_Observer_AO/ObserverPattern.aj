
public aspect ObserverPattern {

	declare parents: GameOfLife extends java.util.Observable;
	declare parents: GameOfLifeUI implements java.util.Observer;

	void GameOfLife.update() {
		setChanged();
		notifyObservers();
	} 
	public void GameOfLifeUI.update(java.util.Observable o, Object arg) {
        repaint(); //Repaint the view to display the changes to the game.
    }
	
	pointcut GameOfLifeUI_constructor(GameOfLife subject, GameOfLifeUI observer): args(String, subject) && execution(GameOfLifeUI.new(String, GameOfLife)) && target(observer);  
	
	after(GameOfLife subject, GameOfLifeUI observer): GameOfLifeUI_constructor(subject, observer) {
		subject.addObserver(observer);
	}	
	
	pointcut subjectChanged(GameOfLife subject): target(subject) && 
		( call(void GameOfLife.advance()) || call(void GameOfLife.toggle(int, int)) );
	
	after(GameOfLife subject): subjectChanged(subject) {
		subject.update();
	}	
	
}

