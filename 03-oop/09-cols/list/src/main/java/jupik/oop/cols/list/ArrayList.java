package jupik.oop.cols.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the list on the Java array
 *
 * @param <E> The type of elements in a list
 */
public class ArrayList<E> implements List<E>
{
	/**
	 * The initial capacity of a list if not specified
	 */
	public static final int INITIAL_CAPACITY = 10;

	/**
	 * The coefficient to multiply the capacity of the list
	 */
	public static final int MULTIPLY_CAPACITY = 2;

	protected int modCount;
	protected int capacity;
	protected int size;
	protected Object []data;

	@SuppressWarnings("unchecked")
	protected E castAt(int index)
	{
		return (E)data[index];
	}

	protected class Iter implements Iterator<E>
	{
		protected int modExp;
		protected int index;

		protected Iter()
		{
			modExp = modCount;
			index = 0;
		}

		@Override
		public boolean hasNext()
		{
			return index != size;
		}

		@Override
		public E next()
		{
			if (modExp != modCount)
			{
				throw new ConcurrentModificationException();
			}

			if (index >= size)
			{
				throw new NoSuchElementException();
			}

			return castAt(index++);
		}
	}

	/**
	 * Create an empty list
	 *
	 * <p>
	 * Set the initial capacity of a list to be {@value #INITIAL_CAPACITY}
	 */
	public ArrayList()
	{
		this(INITIAL_CAPACITY);
	}

	/**
	 * Create an empty list with a specific initial capacity
	 *
	 * <p>
	 * The capacity MUST BE greater than or equal to zero.
	 *
	 * @param capacity the initial capacity of the list
	 */
	public ArrayList(int capacity)
	{
		if (capacity < 0)
		{
			throw new IllegalArgumentException();
		}

		this.capacity = capacity;
		this.size = 0;
		this.data = new Object[capacity];
		this.modCount = 0;
	}

	/**
	 * Create a list to be a shallow copy of an other one
	 *
	 * <p>
	 * The new list refers the same elements.
	 *
	 * <p>
	 * The capacity of the new list will be equal to its size.
	 *
	 * @param l a list to create a copy of
	 */
	public ArrayList(ArrayList<? extends E> l)
	{
		this(l.size);

		for (int i = 0; i < l.size; ++i)
		{
			data[i] = l.data[i];
		}

		size = l.size;
	}

	/**
	 * Insert an element at a specified position
	 *
	 * <p>
	 * If the size of the list equals to the current capacity the capacity
	 * will be multiplied by {@value #MULTIPLY_CAPACITY}.
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @param index the position to insert the element into
	 * @param e     the element to be inserved
	 *
	 * @throws IndexOutOfBoundsException if the index not in the range from
	 */
	@Override
	public void add(int index, E e)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}

		if (size < capacity) {
			for (int i = size; i > index; --i)
			{
				data[i] = data[i - 1];
			}
		}
		else
		{
			int c = capacity > 0 ? capacity * MULTIPLY_CAPACITY : 1;
			Object []t = new Object[c * 2];

			for (int i = 0; i < index; ++i)
			{
				t[i] = data[i];
			}

			for (int i = index; i < size; ++ i)
			{
				t[i + 1] = data[i];
			}

			data = t;
			capacity = c;
		}

		data[index] = e;
		++size;
		++modCount;
	}

	/**
	 * Append an element at the end of the list
	 *
	 * <p>
	 * If the size of the list equals to the current capacity the capacity
	 * will be multiplied by {@value #MULTIPLY_CAPACITY}.
	 *
	 * <p>
	 * The time complexity is O(log n). Although it is O(1) if the size of
	 * the list is lesser than its current capacity.
	 *
	 * @param e the element to be inserted
	 */
	@Override
	public void add(E e)
	{
		add(size, e);
	}

	/**
	 * Remove all elements from the list
	 *
	 * <p>
	 * The current capacity of list is not updated.
	 *
	 * <p>
	 * The time complexity is O(n).
	 */
	@Override
	public void clear()
	{
		for (int i = 0; i < size; ++i)
		{
			data[i] = null;
		}

		size = 0;
		++modCount;
	}

	/**
	 * Create a shallow copy of a list
	 *
	 * <p>
	 * The new list refers the same elements.
	 */
	@Override
	public Object clone()
	{
		return new ArrayList<E>(this);
	}

	/**
	 * Compare a list against an other one
	 *
	 * <p>
	 * The specified object is equal to a list if it is a list of the same
	 * size and for each index corresponding elements are equal.
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @param o an object to compare against the list
	 *
	 * @return True if the specified object is equal to the current one
	 *         or False otherwise
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}

		if (!(o instanceof List<?>))
		{
			return false;
		}

		List<?> l = (List<?>)o;

		if (l.size() != size)
		{
			return false;
		}

		int i = 0;

		for (Object v: l)
		{
			if (data[i] == null)
			{
				if (v != null)
				{
					return false;
				}
			}
			else
			{
				if (!data[i].equals(v))
				{
					return false;
				}
			}

			++i;
		}

		return true;
	}

	/**
	 * Get an element at the specified position
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @param index the index of the element
	 *
	 * @return the element at the index
	 *
	 * @throws IndexOutOfBoundsException if there is no element at the index
	 */
	@Override
	public E get(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		return castAt(index);
	}

	/**
	 * Get the hash code of a list
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @return the hash code
	 */
	@Override
	public int hashCode()
	{
		int hash = 127;

		for (int i = 0; i < size; ++i)
		{
			if (data[i] == null)
			{
				hash ^= 127;
			} else {
				hash ^= data[i].hashCode();
			}
		}

		return hash;
	}

	/**
	 * Get the index of the first occurence of an equal element
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @param e the element to find the first equal
	 *
	 * @return the index of the element or -1 if there is no equal one
	 */
	@Override
	public int indexOf(E e)
	{
		for (int i = 0; i < size; ++i)
		{
			if (
				data[i] == null && e == null ||
				data[i].equals(e)
			)
			{
				return i;
			}
		}

		return -1;
	}

	/**
	 * Get an iterator over elements of a list
	 *
	 * @return an iterator to iterate a list
	 */
	@Override
	public Iterator<E> iterator()
	{
		return new Iter();
	}

	/**
	 * Remove an element at the specified position
	 *
	 * <p>
	 * The current capacity of the list is not updated.
	 *
	 * <p>
	 * The time complexity is O(n). But it is O(1) if the last element of
	 * a list is removed.
	 *
	 * @param index the index of the element to be removed
	 *
	 * @throws IndexOutOfBoundsException if there is no element at the index
	 */
	@Override
	public void remove(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		for (int i = index + 1; i < size; ++i)
		{
			data[i - 1] = data[i];
		}

		++modCount;
		data[--size] = null;
	}

	/**
	 * Remove the first occurence of an equal element
	 *
	 * <p>
	 * The current capacity of the list is not updated.
	 *
	 * <p>
	 * The time complexity is O(n).
	 *
	 * @param e the element to find the first equal
	 *
	 * @return True if there is an equal element or False otherwise
	 */
	@Override
	public boolean remove(E e)
	{
		int i = indexOf(e);

		if (i == -1)
		{
			return false;
		}

		remove(i);

		return true;
	}

	/**
	 * Get the number of elements in a list
	 *
	 * <p>
	 * The time complexity is O(1).
	 *
	 * @return the number of elements
	 */
	@Override
	public int size()
	{
		return size;
	}
}
