public class TestSingleton {
	public static void main(String args[]) {
		Singleton s1 = Singleton.instance();
		System.out.println("First reference:\t" + s1);
		Singleton s2 = Singleton.instance();
		System.out.println("Second reference:\t" + s2);
	}
}