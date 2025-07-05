package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayCarListTest
{
    CarList cars;

    @BeforeEach
    void createCarList()
    {
        cars = new ArrayCarList();

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
        Assertions.assertEquals(size, cars.get(size).number());
    }

    @DisplayName("Test addition at tail")
    @Test
    void testAdditionAtTail()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.add(new ICar(size), size));
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(size, cars.get(size).number());
    }

    @DisplayName("Test addition at head")
    @Test
    void testAdditionAtHead()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.add(new ICar(size), 0));
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(size, cars.get(0).number());
    }

    @DisplayName("Test addition at middle")
    @Test
    void testAdditionAtMiddle()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.add(new ICar(size), size / 2));
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(size, cars.get(size / 2).number());
    }

    @DisplayName("Test exception on get")
    @Test
    void testGetAtException()
    {
        int size = cars.size();

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> cars.get(size)
        );
    }

    @DisplayName("Test remove at tail")
    @Test
    void testRemoveAtTail()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.removeAt(size - 1));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(size - 2, cars.get(size - 2).number());
    }

    @DisplayName("Test remove at head")
    @Test
    void testRemoveAtHead()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.removeAt(0));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(1, cars.get(0).number());
    }

    @DisplayName("Test remove at middle")
    @Test
    void testRemoveAtMiddle()
    {
        int size = cars.size();

        Assertions.assertTrue(cars.removeAt(size / 2));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(size / 2 + 1, cars.get(size / 2).number());
    }

    @DisplayName("Test exception on remove at")
    @Test
    void testRemoveAtException()
    {
        int size = cars.size();

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> cars.removeAt(size)
        );
    }

    @DisplayName("Test remove of last")
    @Test
    void testRemoveLast()
    {
        int size = cars.size();
        Car car = new ICar(size - 1);

        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(size - 2, cars.get(size - 2).number());

        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
    }

    @DisplayName("Test remove of first")
    @Test
    void testRemoveFirst()
    {
        int size = cars.size();
        Car car = new ICar(0);

        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(1, cars.get(0).number());

        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
    }

    @DisplayName("Test remove of middle")
    @Test
    void testRemoveMiddle()
    {
        int size = cars.size();
        Car car = new ICar(size / 2);

        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertEquals(size / 2 + 1, cars.get(size / 2).number());

        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(size - 1, cars.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        Car car = cars.get(0);

        cars.clear();
        Assertions.assertEquals(0, cars.size());

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
        Assertions.assertEquals(null, cars.get(size));

        Assertions.assertTrue(cars.remove(null));
        Assertions.assertEquals(size, cars.size());
        Assertions.assertNotEquals(null, cars.get(size - 1));
    }
}
