package jupik.collections.haset.caset;

import java.util.Arrays;
import java.util.Objects;
import jupik.collections.arlis.capar.Car;

public class HashCarSet implements CarSet
{
    public final int INITIAL_BINS = 0x10;
    public final float DUTY_FACTOR = 0.75f;

    protected class Node
    {
        public Node next;
        public Car car;

        public Node(Node next, Car car)
        {
            this.next = next;
            this.car = car;
        }
    }

    protected static record Pair(Node prev, Node node)
    {
    }

    protected Node []bins;
    protected int size;

    protected void initialise()
    {
        bins = new Node[INITIAL_BINS];
        size = 0;
    }

    protected int binIndex(Node []bins, Car car)
    {
        return Objects.hash(car) % bins.length;
    }

    protected Pair prevOf(Node bin, Car car)
    {
        Node prev = null;
        Node n = bin;

        for (
            ; n != null && !Objects.equals(n.car, car); prev = n, n = n.next)
        {
        }

        return new Pair(prev, n);
    }

    protected void expandBins()
    {
        if (size < DUTY_FACTOR * bins.length)
        {
            return;
        }

        Node []temp = new Node[bins.length * 2];

        for (Node bin: bins)
        {
            for (Node n = bin; n != null; n = n.next)
            {
                int idx = binIndex(temp, n.car);

                n.next = temp[idx];
                temp[idx] = n;
            }
        }

        bins = temp;
    }

    public HashCarSet()
    {
        initialise();
    }

    @Override
    public boolean add(Car car)
    {
        expandBins();

        int idx = binIndex(bins, car);
        Pair pair = prevOf(bins[idx], car);

        if (pair.node != null)
        {
            return false;
        }
        else
        {
            bins[idx] = new Node(bins[idx], car);
            ++size;
            return true;
        }
    }

    @Override
    public boolean remove(Car car)
    {
        int idx = binIndex(bins, car);
        Pair pair = prevOf(bins[idx], car);

        if (pair.node == null)
        {
            return false;
        }
        else
        {
            if (pair.prev == null)
            {
                bins[idx] = pair.node.next;
            }
            else
            {
                pair.prev.next = pair.node.next;
            }
            --size;
            return true;
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        initialise();
    }
}
