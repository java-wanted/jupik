package jupik.collections.hamap.camap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import jupik.collections.arlis.capar.Car;

public class HashCarMap implements CarMap
{
    public final int INITIAL_BINS = 0x10;
    public final float DUTY_FACTOR = 0.75f;

    protected static class Entry
    {
        public Entry next;
        public CarOwner key;
        public Car value;

        public Entry(Entry next, CarOwner key, Car value)
        {
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    protected static class Pair
    {
        public Entry first;
        public Entry second;

        public Pair(Entry first, Entry second)
        {
            this.first = first;
            this.second = second;
        }
    }

    protected Entry []bins;
    protected int size;

    protected void initialise()
    {
        bins = new Entry[INITIAL_BINS];
        size = 0;
    }

    protected int binIndex(Entry []bins, CarOwner key)
    {
        return Objects.hash(key) % bins.length;
    }

    protected Pair nodeOf(Entry entry, CarOwner key)
    {
        Entry prev = null;

        if (key == null)
        {
            for (; entry != null && entry.key != null;
                prev = entry, entry = entry.next)
            {
            }
        }
        else
        {
            for (; entry != null && !key.equals(entry.key);
                prev = entry, entry = entry.next)
            {
            }
        }

        return new Pair(prev, entry);
    }

    protected void expandBins()
    {
        if ((size + 1) > DUTY_FACTOR * bins.length)
        {
            int n = bins.length * 2;
            Entry []temp = new Entry[n];

            for (Entry entry: bins)
            {
                while (entry != null)
                {
                    Entry e = entry;
                    entry = entry.next;

                    int i = binIndex(temp, e.key);
                    e.next = temp[i];
                    temp[i] = e;
                }
            }

            bins = temp;
        }
    }

    public HashCarMap()
    {
        initialise();
    }

    @Override
    public void clear()
    {
        initialise();
    }

    @Override
    public Car get(CarOwner key)
    {
        int i = binIndex(bins, key);
        Pair p = nodeOf(bins[i], key);

        return p.second != null ? p.second.value : null;
    }

    @Override
    public Set<CarOwner> keys()
    {
        Set<CarOwner> keys = new HashSet<>(size);

        for (Entry entry: bins)
        {
            for (; entry != null; entry = entry.next) {
                keys.add(entry.key);
            }
        }

        return keys;
    }

    @Override
    public void put(CarOwner key, Car value)
    {
        expandBins();

        int i = binIndex(bins, key);
        Pair p = nodeOf(bins[i], key);

        if (p.second != null) {
            p.second.value = value;
        } else {
            bins[i] = new Entry(bins[i], key, value);
            ++size;
        }
    }

    @Override
    public boolean remove(CarOwner key)
    {
        int i = binIndex(bins, key);
        Pair p = nodeOf(bins[i], key);

        if (p.second == null) {
            return false;
        } else {
            if (p.first == null) {
                bins[i] = p.second.next;
            } else {
                p.first.next = p.second.next;
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
    public List<Car> values()
    {
        List<Car> values = new ArrayList<>(size);

        for (Entry entry: bins)
        {
            for (; entry != null; entry = entry.next) {
                values.add(entry.value);
            }
        }

        return values;
    }
}
