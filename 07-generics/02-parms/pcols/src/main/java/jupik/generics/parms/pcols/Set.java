package jupik.generics.parms.pcols;

import java.util.Iterator;

/**
 * A set of elements
 *
 * @param <E> The type of elements in the collection
 */
public interface Set<E> extends Collection<E>
{
    /**
     * Add an element into the set
     *
     * @param e the element to be added
     *
     * @return True if the element added or False otherwise
     */
    public boolean add(E e);

    /**
     * Remove all elements from the set
     */
    public void clear();

    /**
     * Check the list contains an equal element
     *
     * @param e the element to check the presense
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean contains(E e);

    /**
     * Get an iterator over elements of the set
     *
     * @return an iterator to iterate a list
     */
    public Iterator<E> iterator();

    /**
     * Remove the first occurence of an equal element
     *
     * @param e the element to find the first equal
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean remove(E e);

    /**
     * Get the number of elements in the list
     *
     * @return the number of elements
     */
    public int size();
}
