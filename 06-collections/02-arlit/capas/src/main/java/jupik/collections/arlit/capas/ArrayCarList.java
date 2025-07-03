package jupik.collections.arlit.capas;

import java.util.Arrays;
import jupik.collections.arlis.capar.Car;

public class ArrayCarList extends jupik.collections.arlis.capar.ArrayCarList implements CarList
{
    @Override
    public void add(Car car, int index)
    {
        validateIndex(size + 1, index);
        prepareForAddition();

        System.arraycopy(cars, index, cars, index + 1, size - index);
        cars[index] = car;
        ++size;
    }

}
