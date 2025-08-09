package jupik.generics.parms.pcols;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of the list on the Java array
 *
 * @param <E> The type of elements in the list
 */
public class ArrayList<E> implements List<E>
{
    /**
     * The initial capacity of the list if not specified
     */
    protected final int INITIAL_CAPACITY = 10;

    protected int modCount;
    protected int size;
    protected Object []elems;

    protected class Iter implements Iterator<E>
    {
        public int modExp = modCount;
        public int index = 0;

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

    @SuppressWarnings("unchecked")
    protected E castAt(int index)
    {
        return (E)elems[index];
    }

    protected void initialise()
    {
        elems = new Object[INITIAL_CAPACITY];
        modCount = 0;
        size = 0;
    }

    protected void prepareForAddition()
    {
        if (size == elems.length)
        {
            elems = Arrays.copyOf(elems, size * 2);
        }
    }

    protected void validateIndex(int last, int index)
    {
        if (index < 0 || index >= last)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    protected int indexOf(E e)
    {
        if (e == null) {
            for (int i = 0; i < size; ++i)
            {
                if (elems[i] == null)
                {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; ++i)
            {
                if (elems[i] != null && elems[i].equals(e))
                {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Create an empty list
     *
     * <p>
     * Set the initial capacity of a list to be {@value #INITIAL_CAPACITY}
     */
    public ArrayList()
    {
        initialise();
    }

    /**
     * Append an element at the end of the list
     *
     * @param e the element to be appended
     *
     * @return True
     */
    public boolean add(E e)
    {
        prepareForAddition();
        elems[size++] = e;
        ++modCount;

        return true;
    }

    /**
     * Insert an element at a specified position
     *
     * @param e     the element to be inserved
     * @param index the position to insert the element into
     *
     * @throws IndexOutOfBoundsException if the index not in the range from
     *         zero to size() inclusive.
     */
    public void add(E e, int index)
    {
        validateIndex(size + 1, index);
        prepareForAddition();

        System.arraycopy(elems, index, elems, index + 1, size - index);
        elems[index] = e;

        ++size;
        ++modCount;
    }

    /**
     * Remove all elements from the list
     */
    public void clear()
    {
        initialise();
    }

    /**
     * Check for an equal element in the list
     *
     * @param e the element to check the presense
     *
     * @return True if there is an equal element or False otherwise
     */
    public boolean contains(E e)
    {
        return indexOf(e) != -1;
    }

    /**
     * Get an element at a specified position
     *
     * @param index the index of the element
     *
     * @return the element at the index
     *
     * @throws IndexOutOfBoundsException if there is no element at the index
     */
    public E get(int index)
    {
        validateIndex(size, index);

        return castAt(index);
    }

    /**
     * Get an iterator over elements of a list
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
        int index = indexOf(e);

        if (index != -1)
        {
            removeAt(index);
        }

        return index != -1;
    }

    /**
     * Remove an element at a specified position
     *
     * @param index the index of the element to be removed
     *
     * @throws IndexOutOfBoundsException if there is no element at the index
     */
    public void removeAt(int index)
    {
        validateIndex(size, index);

        elems[index] = null;
        --size;

        System.arraycopy(elems, index + 1, elems, index, size - index);
        ++modCount;
    }

    /**
     * Get the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return size;
    }
}
