package jupik.collections.ites.cacoi;

import java.util.Iterator;

import jupik.collections.arlis.capar.Car;
import jupik.collections.ites.cacoi.impl.LinkedCarListImpl;

public class LinkedCarList implements CarList
{
    protected LinkedCarListImpl impl;

    protected LinkedCarList()
    {
        impl = new LinkedCarListImpl();
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
    public Iterator<Car> iterator()
    {
        return impl.iterator();
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
