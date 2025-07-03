package jupik.collections.arlis.capar;

import java.util.Arrays;

public class ArrayCarList implements CarList
{
    protected final int INITIAL_SIZE = 10;

    protected Car []cars;
    protected int size;

    public ArrayCarList()
    {
        cars = new Car[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void add(Car car)
    {
        if (size == cars.length)
        {
            cars = Arrays.copyOf(cars, size * 2);
        }

        cars[size++] = car;
    }

    @Override
    public void clear()
    {
        cars = new Car[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public Car get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }

        return cars[index];
    }

    @Override
    public boolean removeAt(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }

        cars[index] = null;
        --size;

        System.arraycopy(cars, index + 1, cars, index, size - index);

        return true;
    }

    @Override
    public boolean remove(Car car)
    {
        if (car == null)
        {
            for (int i = 0; i < size; ++i)
            {
                if (cars[i] == null)
                {
                    return removeAt(i);
                }
            }
        }
        else
        {
            for (int i = 0; i < size; ++i)
            {
                if (cars[i].equals(car))
                {
                    return removeAt(i);
                }
            }
        }

        return false;
    }

    @Override
    public int size()
    {
        return size;
    }
}
