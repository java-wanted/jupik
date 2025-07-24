package jupik.collections.hamap.camap;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashCarMapTest
{
    static class TOwner implements CarOwner
    {
        int index;

        TOwner(int index)
        {
            this.index = index;
        }

        public int id()
        {
            return index;
        }

        public String name()
        {
            return String.format("%d", index);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(this.index);
        }

        @Override
        public boolean equals(Object o)
        {
            if (o instanceof TOwner c)
            {
                return index == c.index;
            }

            return false;
        }
    }

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
            return Objects.hash(index);
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

    HashCarMap cars;

    @BeforeEach
    void createCars()
    {
        cars = new HashCarMap();

        for (int i = 0; i < 34; ++i)
        {
            cars.put(new TOwner(i), new TCar(i));
        }
    }

    @DisplayName("Test get")
    @Test
    void testGet()
    {
        for (int i = 0; i < cars.size(); ++i)
        {
            Assertions.assertEquals(new TCar(i), cars.get(new TOwner(i)));
        }
    }

    @DisplayName("Test add")
    @Test
    void testAddition()
    {
        int size = cars.size();
        CarOwner owner = new TOwner(size);

        Car one = new TCar(size);
        cars.put(owner, one);
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(one, cars.get(owner));

        Car other = new TCar(size + 1);
        cars.put(owner, other);
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(other, cars.get(owner));
    }

    @DisplayName("Test remove")
    @Test
    void testRemove()
    {
        int size = cars.size();
        CarOwner owner = new TOwner(size - 1);

        Assertions.assertTrue(cars.remove(owner));
        Assertions.assertEquals(size - 1, cars.size());
        Assertions.assertFalse(cars.remove(owner));
        Assertions.assertEquals(size - 1, cars.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        cars.clear();
        Assertions.assertEquals(0, cars.size());

        CarOwner owner = new TOwner(0);
        cars.put(owner, null);
        Assertions.assertTrue(cars.remove(owner));
        Assertions.assertEquals(0, cars.size());
    }

    @DisplayName("Test NULL owner")
    @Test
    void testNullCar()
    {
        int size = cars.size();
        Car car = new TCar(size - 1);

        cars.put(null, car);
        Assertions.assertEquals(size + 1, cars.size());
        Assertions.assertEquals(car, cars.get(null));

        Assertions.assertTrue(cars.remove(null));
        Assertions.assertEquals(size, cars.size());
        Assertions.assertEquals(null, cars.get(null));
    }

    @DisplayName("Test keys")
    @Test
    void testKeys()
    {
        int size = cars.size();
        Set<CarOwner> keys = cars.keys();

        Assertions.assertEquals(size, keys.size());
        for (CarOwner key: keys)
        {
            Assertions.assertEquals(new TCar(key.id()), cars.get(key));
        }
    }

    @DisplayName("Test values")
    @Test
    void testValues()
    {
        int size = cars.size();
        boolean []ids = new boolean[size];
        List<Car> values = cars.values();

        Assertions.assertEquals(size, values.size());
        for (Car v: values)
        {
            Assertions.assertFalse(ids[v.number()]);
            ids[v.number()] = true;
        }

        for (boolean v: ids)
        {
            Assertions.assertTrue(v);
        }
    }
}
