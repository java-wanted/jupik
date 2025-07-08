package jupik.collections.ites.cacoi.impl;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jupik.collections.arlis.capar.Car;

public class HashCarSetImpl
    extends jupik.collections.cols.cacol.impl.HashCarSetImpl
    implements Iterable<Car>
{
    protected int modCount = 0;

    protected class Iter implements Iterator<Car>
    {
        public int modExp = modCount;
        public int index;
        public Node next;

        public void nextNode()
        {
            if ((next = next.next) != null)
            {
                return;
            }

            while (++index < bins.length && bins[index] == null)
            {
            }

            if (index < bins.length)
            {
                next = bins[index];
            }
        }

        public Iter()
        {
            for (index = 0; index < bins.length && bins[index] == null; ++index)
            {
            }

            if (index < bins.length)
            {
                next = bins[index];
            }
        }

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

            nextNode();

            return car;
        }
    }

    @Override
    public boolean add(Car car)
    {
        boolean res = super.add(car);

        ++modCount;

        return res;
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
}
