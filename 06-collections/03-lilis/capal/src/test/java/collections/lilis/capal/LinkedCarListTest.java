package jupik.collections.lilis.capal;

import jupik.collections.arlis.capar.Car;
import jupik.collections.arlit.capas.CarList;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class LinkedCarListTest
{
    static class TCar implements Car
    {
        int index;

        TCar(int index)
        {
            this.index = index;
        }

        public String brand()
        {
            return String.format("%d", index);
        }

        public int number()
        {
            return index;
        }

        @Override
        public int hashCode()
        {
            return Integer.hashCode(index);
        }

        @Override
        public boolean equals(Object o)
        {
            if (o instanceof TCar c)
            {
                return index == c.index;
            }

            return false;
        }
    }

    void addCars(CarList cars, int index, int count)
    {
        for (int i = index; i < index + count; ++i)
        {
            cars.add(new TCar(i));
        }
    }

    void removeCars(CarList cars, int index, int count)
    {
        for (int i = index + count; i > index; --i)
        {
            cars.removeAt(i - 1);
        }
    }

    void addCarsAt(CarList cars, int index, int count)
    {
        for (int i = index; i < index + count; ++i)
        {
            cars.add(new TCar(i), index);
        }
    }

    void removeCarsAt(CarList cars, int index, int count)
    {
        while (count-- > 0)
        {
            cars.removeAt(index);
        }
    }

    CarList createCars(int count)
    {
        CarList cars = new LinkedCarList();

        addCars(cars, 0, count);

        return cars;
    }

    @DisplayName("Test size on addition of ")
    @ParameterizedTest(name = "{0}")
    @CsvSource({"0", "1", "11"})
    void testSizeOnAddition(int count)
    {
        CarList cars = createCars(count);

        Assertions.assertEquals(count, cars.size());
    }

    @DisplayName("Test get at ")
    @ParameterizedTest(name = "{0} of {1}")
    @CsvSource({"0,1", "0,11", "1,11", "10,11"})
    void testGetAt(int index, int count)
    {
        CarList cars = createCars(count);
        Car car = cars.get(index);

        Assertions.assertEquals(String.format("%d", index), car.brand());
        Assertions.assertEquals(index, car.number());
    }

    @DisplayName("Test exception on get at ")
    @ParameterizedTest(name = "{0} of {1}")
    @CsvSource({"0,0", "1,1", "-1,1", "11,11"})
    void testGetAtException(int index, int count)
    {
        CarList cars = createCars(count);

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> cars.get(index)
        );
    }

    @DisplayName("Test size on remove at ")
    @ParameterizedTest(name = "{0} of {1}")
    @CsvSource({"0,1", "0,11", "1,11", "10,11"})
    void testSizeOnRemoveAt(int index, int count)
    {
        CarList cars = createCars(count);

        Assertions.assertTrue(cars.removeAt(index));
        Assertions.assertEquals(count - 1, cars.size());
    }

    @DisplayName("Test exception on remove at ")
    @ParameterizedTest(name = "{0} of {1}")
    @CsvSource({"0,0", "1,1", "-1,1", "11,11"})
    void testRemoveAtException(int index, int count)
    {
        CarList cars = createCars(count);

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> cars.removeAt(index)
        );
    }

    @DisplayName("Test remove of car ")
    @ParameterizedTest(name = "\"{0}\" of {1}")
    @CsvSource({"0,1", "0,11", "1,11", "10,11"})
    void testRemove(int index, int count)
    {
        CarList cars = createCars(count);
        Car car = cars.get(index);

        Assertions.assertTrue(cars.remove(car));
        Assertions.assertEquals(count - 1, cars.size());

        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(count - 1, cars.size());
    }

    @DisplayName("Test remove of not added car ")
    @ParameterizedTest(name = "\"{0}\" of {1}")
    @CsvSource({"0,0", "1,1", "11,11"})
    void testSizeOnNotRemove(int index, int count)
    {
        CarList cars = createCars(count);
        Car car = new TCar(index);

        Assertions.assertFalse(cars.remove(car));
        Assertions.assertEquals(count, cars.size());
    }

    @DisplayName("Test size on clear of ")
    @ParameterizedTest(name = "{0}")
    @CsvSource({"0", "1", "11"})
    void testSizeOnClear(int count)
    {
        CarList cars = createCars(count);

        cars.clear();
        Assertions.assertEquals(0, cars.size());
    }

    @DisplayName("Test removal of a NULL")
    @ParameterizedTest(name = " at {0} from {1}")
    @CsvSource({"0,2", "5,11", "9,11"})
    void testRemovalOfNull(int index, int count)
    {
        CarList cars = createCars(index);

        cars.add(null);
        addCars(cars, index + 1, count - index - 1);

        Assertions.assertEquals(count, cars.size());
        Assertions.assertEquals(null, cars.get(index));

        Assertions.assertTrue(cars.remove(null));
        Assertions.assertEquals(count - 1, cars.size());
        Assertions.assertNotEquals(null, cars.get(index));
    }

    @DisplayName("Test addition at")
    @ParameterizedTest(name = " {0} from {1}")
    @CsvSource({"0,0", "0,1", "1,1", "0,10", "10,10"})
    void testAdditionAt(int index, int count)
    {
        CarList cars = createCars(count);
        Car car = new TCar(count + 1);

        cars.add(car, index);
        Assertions.assertEquals(count + 1, cars.size());
        Assertions.assertEquals(car, cars.get(index));
    }

    @DisplayName("Test exception on addition at")
    @ParameterizedTest(name = " {0} from {1}")
    @CsvSource({"1,0", "-1,0", "11,10"})
    void testExceptionOnAdditionAt(int index, int count)
    {
        CarList cars = createCars(count);

        Assertions.assertThrows(
            IndexOutOfBoundsException.class,
            () -> cars.add(new TCar(count + 1), index)
        );
    }

    @DisplayName("Test repeate addition and removal")
    @ParameterizedTest(name = " of {0} {1} times")
    @CsvSource({"1,2", "11,2"})
    void testAddThenRemov(int count, int retry)
    {
        CarList cars = createCars(0);

        for (int i = 0; i < retry; ++i)
        {
            addCars(cars, 0, count);
            Assertions.assertEquals(0, cars.get(0).number());
            Assertions.assertEquals(count - 1, cars.get(count - 1).number());
            removeCars(cars, 0, count);
            Assertions.assertEquals(0, cars.size());
        }
    }

    @DisplayName("Test repeate addition and removal at head")
    @ParameterizedTest(name = " of {0} {1} times")
    @CsvSource({"1,2", "11,2"})
    void testAddThenRemoveHead(int count, int retry)
    {
        CarList cars = createCars(0);

        for (int i = 0; i < retry; ++i)
        {
            addCarsAt(cars, 0, count);
            Assertions.assertEquals(count - 1, cars.get(0).number());
            Assertions.assertEquals(0, cars.get(count - 1).number());
            removeCarsAt(cars, 0, count);
            Assertions.assertEquals(0, cars.size());
        }
    }
}
