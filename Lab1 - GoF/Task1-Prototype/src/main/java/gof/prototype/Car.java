package gof.prototype;

import java.io.Serializable;

// Car class implementing the IPrototype interface, Cloneable, and Serializable
public class Car implements IPrototype<Car>, Serializable, Cloneable {
	protected Engine engine;
	protected String name;
	protected int x, y;

	// Constructor for creating a new Car
	Car(String name, double displacement, int power) {
		engine = new Engine(displacement, power);
		this.name = name;
	}

	// Shallow cloning method using the clone() method
	@Override
	public Car clone() throws CloneNotSupportedException {
		Car car = (Car) super.clone();
		return car;
	}

	// Move the car to a new location
	public void gotoXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Return a string representation of the Car
	public String toString() {
		return "name: " + name + engine.toString() + " location: (" + x + ";" + y + ")\n";
	}

	// Perform tuning on the car's engine
	public void tune() {
		engine.tune();
	}

	// Calculate a hash code for the Car object
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + this.engine.hashCode();
		hash = 41 * hash + this.name.hashCode();
		hash = 41 * hash + this.x;
		hash = 41 * hash + this.y;
		return hash;
	}

	// Check if two Car objects are equal
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Car other = (Car) obj;
		if (!this.engine.equals(other.engine))
			return false;
		if (!this.name.equals(other.name))
			return false;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}
}
