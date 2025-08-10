package jupik.generics.parms.pcols;

import java.util.Iterator;

/**
 * A collection of elements indexed by its keys
 *
 * @param <K> The type of keys
 * @param <E> The type of elements
 */
public interface Map<K, E>
{
    /**
     * Remove all elements from the collection
     */
    public void clear();

    /**
     * Get an element by its key
     *
     * @param key the key of element
     *
     * @return the element or NULL if there is no element for the key
     */
    public E get(K key);

    /**
     * Get the set of keys in the collection
     *
     * @return the set of all keys
     */
    public Set<K> keys();

    /**
     * Add an element to be assotiated with a key
     *
     * @param key the key to associate the element for
     * @param e   the element to be appended
     *
     * @return the previously mapped element or NULL otherwise
     */
    public E put(K key, E e);

    /**
     * Remove the element assotiated with a specified key
     *
     * @param key the key to remove the assotiated element
     *
     * @return True if the key has been removed from the collection or False
     *         otherwise
     */
    public boolean remove(K key);

    /**
     * Get the number of elements in the collection
     *
     * @return the number of elements
     */
    public int size();


    /**
     * Get the list of elements in the collection
     *
     * @return the list of all values
     */
    public List<E> values();

    /**
     * A key-value relation
     */
    public static interface Entry<K, E>
    {
        /**
         * Get the key of the key-value pair
         *
         * @return the key
         */
        public K key();

        /**
         * Get the key of the key-value pair
         *
         * @return the key
         */
        public E value();
    }

    /**
     * Get an iterator over key-value pairs of the map
     *
     * <p>
     * It allows to implement the interface Set above an implementation of this
     * interface.
     *
     * @return the set of entries
     */
    public Iterator<Entry<K, E>> entryIterator();
}
