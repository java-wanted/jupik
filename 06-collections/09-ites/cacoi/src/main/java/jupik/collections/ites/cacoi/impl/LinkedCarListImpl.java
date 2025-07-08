package jupik.collections.ites.cacoi.impl;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jupik.collections.arlis.capar.Car;

public class LinkedCarListImpl
    extends jupik.collections.cols.cacol.impl.LinkedCarListImpl implements
    Iterable<Car>
{
    protected int modCount = 0;

    protected class Iter implements Iterator<Car>
    {
        public int modExp = modCount;
        public Node next = head;

        @Override
        public boolean hasNext()
        {
            return next != null;
        }

        @Override
        public Car next()
        {
			if (modExp != modCount)
			{
				throw new ConcurrentModificationException();
			}

			if (next == null)
			{
				throw new NoSuchElementException();
			}

            Car car = next.car;
			next = next.next;

            return car;
        }
    }

    @Override
    public void add(Car car)
    {
        super.add(car);
        ++modCount;
    }

    @Override
    public void add(Car car, int index)
    {
        super.add(car, index);
        ++modCount;
    }

    @Override
    public void clear()
    {
        super.clear();
        ++modCount;
    }

    @Override
    public Iterator<Car> iterator()
    {
        return new Iter();
    }

    @Override
    public boolean remove(Car car)
    {
        boolean res = super.remove(car);

        ++modCount;

        return res;
    }

    @Override
    public boolean removeAt(int index)
    {
        boolean res = super.removeAt(index);

        ++modCount;

        return res;
    }
}
