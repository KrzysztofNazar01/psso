package gof.prototype;

import java.io.*;
import java.lang.reflect.Method;

// Interface for the Prototype pattern
public interface IPrototype<T> {

    // Shallow cloning method
    default T shallowClone() {
        T clone = null;
        try {
            // Get the class object of the current instance
            Class c = Class.forName(this.getClass().getName());

            // Find the 'clone' method using reflection
            Method method = c.getMethod("clone");

            // Invoke the 'clone' method on the current instance
            clone = (T) method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }

    // Deep cloning method
    default T deepClone() {
        T clone = null;
        try {
            // Serialize the current object to a byte array
            ByteArrayOutputStream baOUT = new ByteArrayOutputStream();
            ObjectOutputStream oOUT = new ObjectOutputStream(baOUT);
            oOUT.writeObject(this);

            // Deserialize the byte array to create a new instance
            ByteArrayInputStream baIN = new ByteArrayInputStream(baOUT.toByteArray());
            ObjectInputStream oIN = new ObjectInputStream(baIN);
            clone = (T) oIN.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
