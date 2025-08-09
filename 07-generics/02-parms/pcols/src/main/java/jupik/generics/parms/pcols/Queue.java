package jupik.generics.parms.pcols;

/**
 * A queue of elements
 *
 * @param <E> The type of elements in the collection
 */
public interface Queue<E> extends Collection<E>
{
    /**
     * Add an element at the tail of the queue
     *
     * @param e the element to be added
     */
    public boolean add(E e);

    /**
     * Get the element at the head of the queue
     *
     * @return the element or NULL if the queue is empty
     */
    public E peek();

    /**
     * Remove the element at the head of the queue
     *
     * @return the element
     *
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public E poll();
}
