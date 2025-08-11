package jupik.generics.parms.pcols;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * An implementation of a collection of elements indexed by its keys
 *
 * @param <K> The type of keys
 * @param <E> The type of elements
 */
public class HashMap<K, E> implements Map<K, E>
{
    /**
     * The initial size of array to hash elements
     */
    public static final int INITIAL_BINS = 0x10;

    /**
     * The factor to duplicate the size of array of hashed elements
     */
    public static final float DUTY_FACTOR = 0.75f;

    protected static class Entry<K, E> implements Map.Entry<K, E>
    {
        public Entry<K, E> next;
        public K key;
        public E value;

        public Entry(Entry<K, E> next, K key, E value)
        {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public K key()
        {
            return key;
        }

        public E value()
        {
            return value;
        }
    }

    protected static class EntryIterator<K, E> implements Iterator<Map.Entry<K, E>>
    {
        public HashMap<K, E> map;
        public int modExp;
        public int index;
        public Entry<K, E> next;

        @SuppressWarnings("unchecked")
        public Entry<K, E> entryAt(Object []bins, int index)
        {
            return (Entry<K, E>)bins[index];
        }

        public EntryIterator(HashMap<K, E> map)
        {
            this.map = map;
            modExp = map.modCount;
            index = 0;

            for (; index < map.bins.length && map.bins[index] == null; ++index)
            {
            }

            if (index < map.bins.length)
            {
                next = entryAt(map.bins, index);
            }
        }

        public void nextNode()
        {
            if ((next = next.next) != null)
            {
                return;
            }

            for (; ++index < map.bins.length && map.bins[index] == null; ++index)
            {
            }

            if (index < map.bins.length)
            {
                next = entryAt(map.bins, index);
            }
        }

        public boolean hasNext()
        {
            return next != null;
        }

        public Entry<K, E> next()
        {
            if (modExp != map.modCount)
            {
                throw new ConcurrentModificationException();
            }

            if (next == null)
            {
                throw new NoSuchElementException();
            }

            Entry<K, E> entry = next;

            nextNode();

            return entry;
        }
    }

    protected static class Pair<T>
    {
        public T first;
        public T second;

        public Pair(T first, T second)
        {
            this.first = first;
            this.second = second;
        }
    }

    protected int modCount;
    protected Object []bins;
    protected int size;

    @SuppressWarnings("unchecked")
    protected Entry<K, E> entryAt(Object []bins, int index)
    {
        return (Entry<K, E>)bins[index];
    }

    protected void initialise()
    {
        bins = new Object[INITIAL_BINS];
        size = 0;
    }

    protected int binIndex(Object []bins, K key)
    {
        return Objects.hash(key) % bins.length;
    }

    protected Pair<Entry<K, E>> nodeOf(Entry<K, E> entry, K key)
    {
        Entry<K, E> prev = null;

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

        return new Pair<>(prev, entry);
    }

    protected void expandBins()
    {
        if ((size + 1) > DUTY_FACTOR * bins.length)
        {
            int n = bins.length * 2;
            Object []temp = new Object[n];

            for (int i = 0; i < bins.length; ++i)
            {
                Entry<K, E> entry = entryAt(bins, i);

                while (entry != null)
                {
                    Entry<K, E> e = entry;
                    entry = entry.next;

                    int j = binIndex(temp, e.key);
                    e.next = entryAt(temp, j);
                    temp[j] = e;
                }
            }

            bins = temp;
        }
    }


    /**
     * Create an empty mapping of keys to elements
     *
     * <p>
     * Set the initial capacity of the hash array to be {@value #INITIAL_BINS}
     */
    public HashMap()
    {
        initialise();
        modCount = 0;
    }

    /**
     * Remove all elements from the mappping
     */
    public void clear()
    {
        initialise();
        ++modCount;
    }

    /**
     * Get an element by its key
     *
     * @param key the key of element
     *
     * @return the element or NULL if there is no element for the key
     */
    public E get(K key)
    {
        int i = binIndex(bins, key);
        Pair<Entry<K, E>> p = nodeOf(entryAt(bins, i), key);

        return p.second != null ? p.second.value : null;
    }

    /**
     * Get the set of keys in the collection
     *
     * @return the set of all keys
     */
    public Set<K> keys()
    {
        Set<K> keys = new HashSet<>();

        for (int i = 0; i < bins.length; ++i)
        {
            Entry<K, E> entry = entryAt(bins, i);

            for (; entry != null; entry = entry.next) {
                keys.add(entry.key);
            }
        }

        return keys;
    }

    /**
     * Add an element to be assotiated with a key
     *
     * @param key the key to associate the element for
     * @param e   the element to be appended
     *
     * @return the previously mapped element or NULL otherwise
     */
    public E put(K key, E e)
    {
        expandBins();

        int i = binIndex(bins, key);
        Pair<Entry<K, E>> p = nodeOf(entryAt(bins, i), key);
        E v = null;

        if (p.second != null) {
            v = p.second.value;
            p.second.value = e;
        } else {
            bins[i] = new Entry<K, E>(entryAt(bins, i), key, e);
            ++size;
        }

        ++modCount;

        return v;
    }

    /**
     * Remove the element assotiated with a specified key
     *
     * @param key the key to remove the assotiated element
     *
     * @return True if the key has been removed from the collection or False
     *         otherwise
     */
    public boolean remove(K key)
    {
        int i = binIndex(bins, key);
        Pair<Entry<K, E>> p = nodeOf(entryAt(bins, i), key);

        if (p.second == null) {
            return false;
        } else {
            if (p.first == null) {
                bins[i] = p.second.next;
            } else {
                p.first.next = p.second.next;
            }

            --size;
            ++modCount;

            return true;
        }
    }

    /**
     * Get the number of elements in the collection
     *
     * @return the number of elements
     */
    public int size()
    {
        return size;
    }

    /**
     * Get the list of elements in the collection
     *
     * @return the list of all values
     */
    public List<E> values()
    {
        List<E> values = new ArrayList<>();

        for (int i = 0; i < bins.length; ++i)
        {
            Entry<K, E> entry = entryAt(bins, i);

            for (; entry != null; entry = entry.next)
            {
                values.add(entry.value);
            }
        }

        return values;
    }

    /**
     * Get an iterator over key-value pairs of the map
     *
     * <p>
     * It allows to implement the interface Set above this implementation of
     * the interface Map.
     *
     * @return the set of entries
     */
    public Iterator<Map.Entry<K, E>> entryIterator()
    {
        return new EntryIterator<K, E>(this);
    }
}
