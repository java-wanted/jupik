package jupik.collections.haset.caset;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class HashCarSetTest
{
    static final int LAST_INDEX = 0x10;

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

    class TCarSet implements CarSet
    {
        Car []cars;
        int size;

        TCarSet(int max)
        {
            cars = new Car[max];
            size = 0;
        }

        @Override
        public boolean add(Car car)
        {
            int index = car.number();

            if (cars[index] != null)
            {
                return false;
            } else {
                cars[index] = car;
                ++size;
                return true;
            }
        }

        @Override
        public boolean remove(Car car)
        {
            int index = car.number();

            if (cars[index] == null)
            {
                return false;
            } else {
                cars[index] = null;
                --size;
                return true;
            }
        }

        @Override
        public int size()
        {
            return size;
        }

        @Override
        public void clear()
        {
            cars = new Car[cars.length];
            size = 0;
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
        CarSet cars = new TCarSet(LAST_INDEX);

        addCars(cars, first, last);

        return cars;
    }

    @DisplayName("Test addition")
    @ParameterizedTest(name = " of {0} to {1}")
    @CsvSource({"0,1", "1,2", "0,10", "1,11"})
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
}
