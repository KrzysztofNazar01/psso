public class Screen implements Observer {
    private String name;
    
    public Screen(String name) {
        this.name = name; 
    }
     
    public void display(String s) {
	    System.out.println(name + ": " + s);
    }   

    public void refresh(Subject s) { 
        display(s.toString());
    }
        
}
