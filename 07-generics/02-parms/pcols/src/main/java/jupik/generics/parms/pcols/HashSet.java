package jupik.generics.parms.pcols;

import java.util.Iterator;

/**
 * A set of elements
 *
 * The set is mapemented about the HashSet collection.
 *
 * @param <E> The type of elements in the collection
 */
public class HashSet<E> implements Set<E>
{
    /**
     * The initial size of array to hash elements
     */
    public static final int INITIAL_BINS = HashMap.INITIAL_BINS;

    /**
     * The factor to duplicate the size of array of hashed elements
     */
    public static final float DUTY_FACTOR = HashMap.DUTY_FACTOR;

    protected static final Object dummy = new Object();

    protected HashMap<E, Object> map;

    /**
     * Create an empty hash set
     */
    public HashSet()
    {
        map = new HashMap<E, Object>();
    }

    /**
     * Add an element into the set
     *
     * @param e the element to be added
     *
     * @return True if the element added or False otherwise
     */
    public boolean add(E e)
    {
        return map.put(e, dummy) == null;
    }

    /**
     * Remove all elements from the set
     */
    public void clear()
    {
        map.clear();
    }

    /**
     * Check the list contains an equal element
     *
     * @param e the element to check the presense
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean contains(E e)
    {
        return map.get(e) != null;
    }

    protected class Iter implements Iterator<E>
    {
        public Iterator<Map.Entry<E, Object>> iter = map.entryIterator();

        public boolean hasNext()
        {
            return iter.hasNext();
        }

        public E next()
        {
            return iter.next().key();
        }
    }

    /**
     * Get an iterator over elements of the set
     *
     * @return an iterator to iterate a list
     */
    public Iterator<E> iterator()
    {
        return new Iter();
    }

    /**
     * Remove the first occurence of an equal element
     *
     * @param e the element to find the first equal
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean remove(E e)
    {
        return map.remove(e);
    }

    /**
     * Get the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return map.size();
    }
}
