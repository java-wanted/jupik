package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashCarSetTest
{
    CarSet cars;

    @BeforeEach
    void createCarSet()
    {
        cars = new HashCarSet();

        for (int i = 0; i < 15; ++i)
        {
            cars.add(new ICar(i));
        }
    }

    @DisplayName("Test addition")
    @Test
    void testAddition()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.add(new ICar(size)));
        Assertions.assertEquals(size + 1, cars.size());

        Assertions.assertFalse(cars.add(new ICar(size)));
        Assertions.assertEquals(size + 1, cars.size());
    }

    @DisplayName("Test remove")
    @Test
    void testRemove()
    {
        int size = cars.size();
        Car car = new ICar(size - 1);

        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        cars.clear();
        Assertions.assertEquals(0, cars.size());

        Car car = new ICar(0);
        Assertions.assertTrue(cars.add(car));
        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(0, cars.size());
    }

    @DisplayName("Test NULL car")
    @Test
    void testNullCar()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.add(null));
        Assertions.assertEquals(size + 1, cars.size());

        Assertions.assertTrue(cars.remove(null));
        Assertions.assertEquals(size, cars.size());
    }
}
