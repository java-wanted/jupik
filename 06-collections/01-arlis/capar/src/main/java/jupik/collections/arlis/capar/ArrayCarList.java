package jupik.collections.arlis.capar;

import java.util.Arrays;

public class ArrayCarList implements CarList
{
    protected final int INITIAL_SIZE = 10;

    protected Car []cars;
    protected int size;

    protected void initialise()
    {
        cars = new Car[INITIAL_SIZE];
        size = 0;
    }

    protected void prepareForAddition()
    {
        if (size == cars.length)
        {
            cars = Arrays.copyOf(cars, size * 2);
        }
    }

    protected void validateIndex(int last, int index)
    {
        if (index < 0 || index >= last)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    protected int indexOf(Car car)
    {
        if (car == null) {
            for (int i = 0; i < size; ++i)
            {
                if (cars[i] == null)
                {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; ++i)
            {
                if (cars[i].equals(car))
                {
                    return i;
                }
            }
        }

        return -1;
    }

    public ArrayCarList()
    {
        initialise();
    }

    @Override
    public void add(Car car)
    {
        prepareForAddition();
        cars[size++] = car;
    }

    @Override
    public void clear()
    {
        initialise();
    }

    @Override
    public Car get(int index)
    {
        validateIndex(size, index);

        return cars[index];
    }

    @Override
    public boolean removeAt(int index)
    {
        validateIndex(size, index);

        cars[index] = null;
        --size;

        System.arraycopy(cars, index + 1, cars, index, size - index);

        return true;
    }

    @Override
    public boolean remove(Car car)
    {
        int index = indexOf(car);

        if (index != -1)
        {
            return removeAt(index);
        }

        return false;
    }

    @Override
    public int size()
    {
        return size;
    }
}
