import java.util.HashSet;
import java.util.Iterator;

public abstract class Subject {  
    private HashSet<Observer> observers = new HashSet<Observer>();
    
    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        Iterator<Observer> iter = observers.iterator(); 
        while(iter.hasNext()) {
        	iter.next().refresh(this);
        }
    }
}