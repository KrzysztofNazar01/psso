package gof.prototype;

import org.junit.Assert;
import org.junit.Test;

public class TestCar {
    @Test
    public void testShallowCopy() {
        Car audi = new Car("A6", 1.9, 130);

        Car copy1 = audi.shallowClone();

        // Assert that the engine of the copy is the same as the original
        Assert.assertTrue(copy1.engine == audi.engine);

        // Move the original Car object to a new location
        audi.gotoXY(40, 50);

        Assert.assertNotEquals(copy1.x, audi.x);
        Assert.assertNotEquals(copy1.y, audi.y);

        // Assert that the engine of the copy is still the same as the original
        Assert.assertTrue(copy1.engine == audi.engine);
    }

    @Test
    public void testDeepCopy() {
        Car audi = new Car("A6", 1.9, 130);

        Car copy1 = audi.deepClone();

        // Assert that the engine of the copy is not the same as the original
        Assert.assertFalse(copy1.engine == audi.engine);

        // Move the original Car object to a new location
        audi.gotoXY(40, 50);

        // Assert that the location (x and y) of the copy is not equal to the original
        Assert.assertNotEquals(copy1.x, audi.x);
        Assert.assertNotEquals(copy1.y, audi.y);
    }

}
