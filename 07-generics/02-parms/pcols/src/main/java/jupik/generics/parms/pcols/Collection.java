package jupik.generics.parms.pcols;

import java.util.Iterator;

/**
 * A collection of elements
 *
 * @param <E> The type of elements in the collection
 */
public interface Collection<E> extends Iterable<E>
{
    /**
     * Add an element to the collecion
     *
     * @param e the element to be added
     *
     * @return True if the element has been added or False otherwise
     */
    public boolean add(E e);

    /**
     * Remove all elements from the collection
     */
    public void clear();

    /**
     * Get an iterator over elements of the collection
     *
     * @return an iterator to iterate elements
     */
    public Iterator<E> iterator();

    /**
     * Remove the first occurence of an equal element
     *
     * @param e the elemt to find the first equal
     *
     * @return True if there is an equal element of False otherwise
     */
    public boolean remove(E e);

    /**
     * Get the number of elements in the collection
     *
     * @return the number of elements
     */
    public int size();
}
