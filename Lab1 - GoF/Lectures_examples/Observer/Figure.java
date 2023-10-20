import java.awt.Color;

public abstract class Figure extends Subject {
    private Color color;
    protected Figure(Color color) {
    	this.color=color; 
    }
    public Color getColor() { 
    	return color; 
    }
    public void setColor(Color color) { 
    	this.color=color; 
    	notifyObservers();
    }
    public abstract void moveBy(int dx, int dy);
}