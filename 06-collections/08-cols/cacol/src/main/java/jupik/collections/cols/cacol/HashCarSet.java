package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;
import jupik.collections.cols.cacol.impl.HashCarSetImpl;

public class HashCarSet implements CarSet
{
    protected HashCarSetImpl impl;

    protected HashCarSet()
    {
        impl = new HashCarSetImpl();
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
    public boolean contains(Car car)
    {
        return impl.contains(car);
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
