package jupik.generics.parms.pcols;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a linked list
 *
 * <p>
 * The list implements the List and the Queue interfaces.
 *
 * @param <E> The type of elements in the list
 */
public class LinkedList<E> implements List<E>, Queue<E>
{
    protected static class Node<E>
    {
        public Node<E> prev;
        public Node<E> next;
        public E elem;

        protected Node(E elem)
        {
            this.elem = elem;
        }
    }

    protected static class Iter<E> implements Iterator<E>
    {
        public LinkedList<E> list;
        public int modExp;
        public Node<E> next;

        public Iter(LinkedList<E> list)
        {
            this.list = list;
            modExp = list.modCount;
            next = list.head;
        }

        @Override
        public boolean hasNext()
        {
            return next != null;
        }

        @Override
        public E next()
        {
            if (modExp != list.modCount)
            {
                throw new ConcurrentModificationException();
            }

            if (next == null)
            {
                throw new NoSuchElementException();
            }

            E elem = next.elem;
            next = next.next;

            return elem;
        }
    }

    protected int modCount = 0;
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    protected void initialise()
    {
        Node<E> node = head;

        head = null;
        tail = null;
        size = 0;
        ++modCount;

        for (; node != null; node = node.next)
        {
            node.prev = null;
        }
    }

    protected void validateIndex(int last, int index)
    {
        if (index < 0 || index >= last)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    protected Node<E> nodeAt(int index)
    {
        if (index == size)
        {
            return null;
        }
        else if (index < size / 2)
        {
            Node<E> node = head;

            for (; index-- > 0; node = node.next)
            {
            }

            return node;
        }
        else
        {
            Node<E> node = tail;

            for (index = size - index; --index > 0; node = node.prev)
            {
            }

            return node;
        }
    }

    protected void addNode(Node<E> next, Node<E> node)
    {
        if (tail == null)
        {
            tail = node;
            head = node;
        }
        else
        {
            if (next == null)
            {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            else if (next.prev == null)
            {
                node.next = next;
                next.prev = node;
                head = node;
            }
            else
            {
                node.prev = next.prev;
                node.next = next;
                next.prev.next = node;
                next.prev = node;
            }
        }

        ++size;
        ++modCount;
    }

    protected Node<E> nodeOf(E elem)
    {
        Node<E> node = head;

        if (elem == null) {
            for (; node != null && node.elem != null; node = node.next)
            {
            }
        } else {
            for (; node != null && !node.elem.equals(elem); node = node.next)
            {
            }
        }

        return node;
    }

    protected boolean removeNode(Node<E> node)
    {
        if (node.prev == null)
        {
            head = node.next;
        }
        else
        {
            node.prev.next = node.next;
        }

        if (node.next == null)
        {
            tail = node.prev;
        }
        else
        {
            node.next.prev = node.prev;
        }

        --size;
        ++modCount;

        return true;
    }

    /**
     * Create an empty list
     */
    public LinkedList()
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
        addNode(null, new Node<>(e));

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
        addNode(nodeAt(index), new Node<>(e));
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
        return nodeOf(e) != null;
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

        return nodeAt(index).elem;
    }

    /**
     * Get an iterator over elements of a list
     *
     * @return an iterator to iterate a list
     */
    public Iterator<E> iterator()
    {
        return new Iter<E>(this);
    }

    /**
     * Get the first element of the list
     *
     * @return the element or NULL if the queue is empty
     */
    public E peek()
    {
        return size() > 0 ? nodeAt(0).elem : null;
    }

    /**
     * Remove the first element of the list
     *
     * @return the element
     *
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public E poll()
    {
        E elem = get(0);

        removeNode(head);

        return elem;
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
        Node<E> node = nodeOf(e);

        return node != null ? removeNode(node) : false;
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

        removeNode(nodeAt(index));
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
