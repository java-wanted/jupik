package jupik.oop.cols.list;

import java.util.Iterator;

/**
 * A list of elements
 *
 * <p>
 * Declares a collection to keep an ordered list of elements of the same
 * type. An element could be accessed by its index in the list.
 *
 * @param <E> The type of elements in a list
 */
public interface List<E> extends Iterable<E>
{
	/**
	 * Insert an element at a specified position
	 *
	 * @param index the position to insert the element into
	 * @param e     the element to be inserved
	 *
	 * @throws IndexOutOfBoundsException if the index not in the range from
	 * zero to size() inclusive.
	 */
	public void add(int index, E e);

	/**
	 * Append an element at the end of the list
	 *
	 * @param e the element to be inserted
	 */
	public void add(E e);

	/**
	 * Remove all elements from the list
	 */
	public void clear();

	/**
	 * Compare a list against an other one
	 *
	 * <p>
	 * The specified object is equal to a list if it is a list of the same
	 * size and for each index corresponding elements are equal.
	 *
	 * @param o an object to compare against the list
	 *
	 * @return True if the specified object is equal to the current one
	 *         or False otherwise
	 */
	public boolean equals(Object o);

	/**
	 * Get an element at the specified position
	 *
	 * @param index the index of the element
	 *
	 * @return the element at the index
	 *
	 * @throws IndexOutOfBoundsException if there is no element at the index
	 */
	public E get(int index);

	/**
	 * Get the hash code of a list
	 *
	 * @return the hash code
	 */
	public int hashCode();

	/**
	 * Get the index of the first occurence of an equal element
	 *
	 * @param e the element to find the first equal
	 *
	 * @return the index of the element or -1 if there is no equal one
	 */
	public int indexOf(E e);

	/**
	 * Get an iterator over elements of a list
	 *
	 * @return an iterator to iterate a list
	 */
	public Iterator<E> iterator();

	/**
	 * Remove an element at the specified position
	 *
	 * @param index the index of the element to be removed
	 *
	 * @throws IndexOutOfBoundsException if there is no element at the index
	 */
	public void remove(int index);

	/**
	 * Remove the first occurence of an equal element
	 *
	 * @param e the element to find the first equal
	 *
	 * @return True if there is an equal element or False otherwise
	 */
	public boolean remove(E e);

	/**
	 * Get the number of elements in a list
	 *
	 * @return the number of elements
	 */
	public int size();
}
