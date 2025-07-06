package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

public class HashCarSet implements CarSet
{
    protected jupik.collections.haset.caset.CarSet impl;

    protected HashCarSet()
    {
        impl = new jupik.collections.haset.caset.HashCarSet();
    }

    @Override
    public boolean add(Car car)
    {
        return impl.add(car);
    }

    @Override
    public void clear()
    {
        impl.clear();
    }

    @Override
    public boolean remove(Car car)
    {
        return impl.remove(car);
    }

    @Override
    public int size()
    {
        return impl.size();
    }
}
