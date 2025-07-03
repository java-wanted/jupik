package jupik.collections.arlit.capas;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ArrayCarListTest
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

    CarList createCars(int count)
    {
        CarList cars = new ArrayCarList();

        for (int i = 0; i < count; ++i)
        {
            cars.add(new TCar(i));
        }

        return cars;
    }

    @DisplayName("Test addition of a car")
    @ParameterizedTest(name = " at {0} from {1}")
    @CsvSource({"0,0", "0,1", "1,1", "0,10", "10,10"})
    void testAdditionAt(int index, int count)
    {
        CarList cars = createCars(count);
        Car car = new TCar(count + 1);

        cars.add(car, index);
        Assertions.assertEquals(count + 1, cars.size());
        Assertions.assertEquals(car, cars.get(index));
    }

    @DisplayName("Test exception of addition of a car")
    @ParameterizedTest(name = " at {0} from {1}")
    @CsvSource({"1,0", "-1,0", "11,10"})
    void testExceptionOnAdditionAt(int index, int count)
    {
        CarList cars = createCars(count);

        Assertions.assertThrows(
            IndexOutOfBoundsException.class,
            () -> cars.add(new TCar(count + 1), index)
        );
    }
}
