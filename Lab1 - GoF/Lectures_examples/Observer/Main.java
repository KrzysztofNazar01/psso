import java.awt.Color; 

 
public class Main {               
  
    public static void main(String argv[]) {
	
    	Point p1 = new Point(0, 0, Color.blue);
    	Point p2 = new Point(2, 2, Color.red);
    	Point p3 = new Point(4, 4, Color.red);
    	Line l1 = new Line(p2,p3, Color.red);
    	
    	Screen s1 = new Screen("s1");
    	Screen s2 = new Screen("s2");
    	
        System.out.println("Sreen s1 observes p1: "+p1);
        System.out.println("Sreen s2 observes l1: "+l1);
    	p1.addObserver(s1); 
    	l1.addObserver(s2);
          	
        System.out.println("Changing l1's color:");    	
    	l1.setColor(Color.green);

        System.out.println("Moveing l1's by [6;6]:");    	
    	l1.moveBy(6,6); 
    	
    	System.out.println("Changing p1's x-coordinate:");
    	p1.setX(1);     	
    }
}
