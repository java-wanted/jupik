package jupik.generics.parms.pcols;

import java.util.Iterator;

/**
 * A list of elements
 *
 * <p>
 * An element could be accessed by its index in the list.
 *
 * @param <E> The type of elements in the collection
 */
public interface List<E> extends Collection<E>
{
    /**
     * Append an element at the end of the list
     *
     * @param e the element to be appended
     *
     * @return True if the element appended or False otherwise
     */
    public boolean add(E e);

    /**
     * Insert an element at a specified position
     *
     * @param e     the element to be inserved
     * @param index the position to insert the element into
     *
     * @throws IndexOutOfBoundsException if the index not in the range from
     *         zero to size() inclusive.
     */
    public void add(E e, int index);

    /**
     * Remove all elements from the list
     */
    public void clear();

    /**
     * Check for an equal element in the list
     *
     * @param e the element to check the presense
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean contains(E e);

    /**
     * Get an element at a specified position
     *
     * @param index the index of the element
     *
     * @return the element at the index
     *
     * @throws IndexOutOfBoundsException if there is no element at the index
     */
    public E get(int index);

    /**
     * Get an iterator over elements of a list
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
     * Remove an element at a specified position
     *
     * @param index the index of the element to be removed
     *
     * @throws IndexOutOfBoundsException if there is no element at the index
     */
    public void removeAt(int index);

    /**
     * Get the number of elements in the list
     *
     * @return the number of elements
     */
    public int size();
}
