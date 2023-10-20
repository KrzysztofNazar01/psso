public class Singleton {
	private static Singleton uniqueInstance = null; // The private reference to the one and only instance.
	private int data = 10;
	//Make the instance() synchronized, if two threads may concurrently invoke it.
	public static Singleton instance() {
		if(uniqueInstance == null) uniqueInstance = new Singleton();
		return uniqueInstance;
	}
	private Singleton() {}
}