package jupik.collections.queue.caque;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedCarListTest
{
    LinkedCarList cars;

    @BeforeEach
    void createCarQueue()
    {
        cars = new LinkedCarList();

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
        Car car = new ICar(size);

        Assertions.assertTrue(cars.add(car));
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertSame(cars.get(size), car);
    }

    @DisplayName("Test peek")
    @Test
    void testPeek()
    {
        Car car = cars.peek();

        Assertions.assertSame(cars.get(0), car);
    }

    @DisplayName("Test peek from empty")
    @Test
    void testPeekEmpty()
    {
        cars.clear();

        Assertions.assertNull(cars.peek());
    }

    @DisplayName("Test poll")
    @Test
    void testPoll()
    {
        int size = cars.size();
        Car first = cars.get(0);
        Car second = cars.get(1);
        Car car = cars.poll();

        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertSame(first, car);
        Assertions.assertSame(second, cars.get(0));
    }

    @DisplayName("Test poll from empty")
    @Test
    void testPollEmpty()
    {
        cars.clear();

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> cars.poll()
        );
    }
}
