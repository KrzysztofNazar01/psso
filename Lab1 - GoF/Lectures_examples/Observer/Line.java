import java.awt.Color;
  
public class Line extends Figure {
  protected Point p1;  
  protected Point p2;

  public Line(Point p1, Point p2, Color color) {
    super(color);
    this.p1=p1;
    this.p2=p2;
  }
  public Point getP1() { 
    return p1; 
  }
  public Point getP2() { 
    return p2; 
  }
  public void setP1(Point p1) { 
    this.p1 = p1;
    notifyObservers();
  }
  public void setP2(Point p2) { 
    this.p2 = p2; 
    notifyObservers();
  }
  public void moveBy(int dx, int dy) {
	  p1.moveBy(dx, dy);
	  p2.moveBy(dx, dy);
	  notifyObservers();
  }
  public String toString() {
    return "Line from (" + p1.getX() + ";" + p1.getY() + ") to (" + p2.getX() + ";" + p2.getY() + ") "+getColor();
  }
  
}
