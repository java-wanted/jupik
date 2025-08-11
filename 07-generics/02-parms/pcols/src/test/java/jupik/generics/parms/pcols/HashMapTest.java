package jupik.generics.parms.pcols;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashMapTest
{
    Map<Integer, Integer> elems;

    @BeforeEach
    void createMap()
    {
        elems = new HashMap<>();

        for (int i = 0; i < HashMap.INITIAL_BINS * 2 + 2; ++i)
        {
            elems.put(i, i + 100);
        }
    }

    @DisplayName("Test values of elements")
    @Test
    void testGet()
    {
        for (int i = 0; i < elems.size(); ++i)
        {
            Assertions.assertEquals(i + 100, elems.get(i));
        }
    }

    @DisplayName("Test addition")
    @Test
    void testAddition()
    {
        int size = elems.size();
        Integer key = size;

        Integer one = size;
        Assertions.assertNull(elems.put(key, one));
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(one, elems.get(key));

        Integer other = size + 1;
        Assertions.assertEquals(one, elems.put(key, other));
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(other, elems.get(key));
    }

    @DisplayName("Test remove")
    @Test
    void testRemove()
    {
        int size = elems.size();
        Integer key = size - 1;

        Assertions.assertTrue(elems.remove(key));
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertFalse(elems.remove(key));
        Assertions.assertEquals(size - 1, elems.size());
    }

    @DisplayName("Test remove alien")
    @Test
    void testRemoveAlien()
    {
        int size = elems.size();

        Assertions.assertFalse(elems.remove(size));
        Assertions.assertEquals(size, elems.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        Integer key = 0;
        elems.clear();
        Assertions.assertEquals(0, elems.size());

        Assertions.assertNull(elems.put(key, null));
        Assertions.assertTrue(elems.remove(key));
        Assertions.assertEquals(0, elems.size());
    }

    @DisplayName("Test values")
    @Test
    void testValues()
    {
        int size = elems.size();
        boolean []ids = new boolean[size];
        List<Integer> values = elems.values();

        Assertions.assertEquals(size, values.size());

        for (Integer v: values)
        {
            Assertions.assertFalse(ids[v - 100]);
            ids[v - 100] = true;
        }

        for (boolean v: ids)
        {
            Assertions.assertTrue(v);
        }
    }

    @DisplayName("Test entry iterator")
    @Test
    void testIter()
    {
        int size = elems.size();
        boolean []ids = new boolean[size];
        Iterator<Map.Entry<Integer, Integer>> iter = elems.entryIterator();

        while (iter.hasNext())
        {
            Map.Entry<Integer, Integer> e = iter.next();
            Assertions.assertEquals(e.key() + 100, e.value());
            Assertions.assertFalse(ids[e.key()]);
            ids[e.key()] = true;
        }

        for (boolean v: ids)
        {
            Assertions.assertTrue(v);
        }
    }

    @DisplayName("Test iterator exceptions")
    @Test
    void testIterException()
    {
        int size = elems.size();
        final Iterator<Map.Entry<Integer, Integer>> i0 = elems.entryIterator();

        while (i0.hasNext())
        {
            i0.next();
        }

        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> i0.next()
        );

        final Iterator<Map.Entry<Integer, Integer>> i1 = elems.entryIterator();
        elems.put(size, size + 100);

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i1.next()
        );

        final Iterator<Map.Entry<Integer, Integer>> i2 = elems.entryIterator();
        elems.remove(size);

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i2.next()
        );

        final Iterator<Map.Entry<Integer, Integer>> i3 = elems.entryIterator();
        elems.clear();

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i3.next()
        );
    }

    @DisplayName("Test keys")
    @Test
    void testKeys()
    {
        int size = elems.size();
        boolean []ids = new boolean[size];
        Set<Integer> keys = elems.keys();
        Assertions.assertEquals(size, keys.size());

        for (Integer k: keys)
        {
            Assertions.assertFalse(ids[k]);
            ids[k] = true;
        }

        for (boolean v: ids)
        {
            Assertions.assertTrue(v);
        }
    }
}
