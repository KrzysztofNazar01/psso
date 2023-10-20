import java.awt.Color;

public class Point extends Figure {
  private int x;
  private int y;
    
  public Point(int x, int y, Color color) {
    super(color);
    this.x=x;
    this.y=y;
  }
  public int getX() { 
    return x; 
  }
  public int getY() { 
    return y; 
  } 
  public void setX(int x) { 
    this.x = x; 
    notifyObservers();
  }
  public void setY(int y) { 
    this.y = y;
    notifyObservers();
  }
  
  public void moveBy(int dx, int dy) {
	  x = x+dx;
	  y = y+dy;
	  notifyObservers();
  }
  public String toString() {
    return "Point ("+x+";"+y+") "+getColor();
  }
}
