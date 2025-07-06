package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;
import jupik.collections.cols.cacol.impl.ArrayCarListImpl;

public class ArrayCarList implements CarList
{
    protected ArrayCarListImpl impl;

    protected ArrayCarList()
    {
        impl = new ArrayCarListImpl();
    }

    @Override
    public boolean add(Car car)
    {
        impl.add(car);
        return true;
    }

    @Override
    public boolean add(Car car, int index)
    {
        impl.add(car, index);
        return true;
    }

    @Override
    public void clear()
    {
        impl.clear();
    }

    @Override
    public boolean contains(Car car)
    {
        return impl.contains(car);
    }

    @Override
    public Car get(int index)
    {
        return impl.get(index);
    }

    @Override
    public boolean remove(Car car)
    {
        return impl.remove(car);
    }

    @Override
    public boolean removeAt(int index)
    {
        return impl.removeAt(index);
    }

    @Override
    public int size()
    {
        return impl.size();
    }
}
