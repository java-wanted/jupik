package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

public class LinkedCarList implements CarList
{
    protected jupik.collections.arlit.capas.CarList impl;

    protected LinkedCarList()
    {
        impl = new jupik.collections.lilis.capal.LinkedCarList();
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
