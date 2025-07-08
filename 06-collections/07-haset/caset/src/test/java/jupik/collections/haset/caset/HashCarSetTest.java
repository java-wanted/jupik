package jupik.collections.haset.caset;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class HashCarSetTest
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

    void addCars(CarSet cars, int first, int last)
    {
        for (int i = first; i < last; ++i)
        {
            Assertions.assertTrue(cars.add(new TCar(i)));
        }
    }

    void addNoCars(CarSet cars, int first, int last)
    {
        for (int i = first; i < last; ++i)
        {
            Assertions.assertFalse(cars.add(new TCar(i)));
        }
    }

    void removeCars(CarSet cars, int first, int last)
    {
        for (int i = first; i < last; ++i)
        {
            Assertions.assertTrue(cars.remove(new TCar(i)));
        }
    }

    void removeNoCars(CarSet cars, int first, int last)
    {
        for (int i = first; i < last; ++i)
        {
            Assertions.assertFalse(cars.remove(new TCar(i)));
        }
    }

    CarSet createCars(int first, int last)
    {
        CarSet cars = new HashCarSet();

        addCars(cars, first, last);

        return cars;
    }

    @DisplayName("Test addition")
    @ParameterizedTest(name = " of {0} to {1}")
    @CsvSource({"0,1", "1,2", "1,11", "0,34"})
    void testAddition(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertEquals(last - first, cars.size());
        addNoCars(cars, first, last);
        Assertions.assertEquals(last - first, cars.size());
    }

    @DisplayName("Test removal")
    @ParameterizedTest(name = " of {0} to {1}")
    @CsvSource({"0,1", "1,2", "0,10", "1,11"})
    void testRemoval(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertEquals(last - first, cars.size());
        removeCars(cars, first, last);
        Assertions.assertEquals(0, cars.size());
        removeNoCars(cars, first, last);
        Assertions.assertEquals(0, cars.size());
    }

    @DisplayName("Test clear")
    @ParameterizedTest(name = " of {0}..{1}")
    @CsvSource({"0,1", "1,2", "0,10", "1,11"})
    void testClear(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertEquals(last - first, cars.size());
        cars.clear();
        Assertions.assertEquals(0, cars.size());
        cars.clear();
        Assertions.assertEquals(0, cars.size());
    }

    @DisplayName("Test NULL addition")
    @ParameterizedTest(name = " of {0} to {1}")
    @CsvSource({"0,1", "1,2", "0,10", "1,11"})
    void testNullAddition(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertTrue(cars.add(null));
        Assertions.assertEquals(last - first + 1, cars.size());
        Assertions.assertFalse(cars.add(null));
        Assertions.assertEquals(last - first + 1, cars.size());
    }

    @DisplayName("Test NULL removal")
    @ParameterizedTest(name = " of {0} to {1}")
    @CsvSource({"0,1", "1,2", "0,10", "1,11"})
    void testNullRemoval(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertTrue(cars.add(null));
        Assertions.assertTrue(cars.remove(null));
        Assertions.assertEquals(last - first, cars.size());
        Assertions.assertFalse(cars.remove(null));
        Assertions.assertEquals(last - first, cars.size());
    }

    @DisplayName("Test NULL clear")
    @ParameterizedTest(name = " of {0}..{1}")
    @CsvSource({"0,1", "1,11"})
    void testNullClear(int first, int last)
    {
        CarSet cars = createCars(first, last);

        Assertions.assertTrue(cars.add(null));
        cars.clear();
        Assertions.assertEquals(0, cars.size());
        cars.clear();
        Assertions.assertEquals(0, cars.size());
    }
}
