package jupik.generics.parms.pcols;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashSetTest
{
    Set<Integer> elems;

    @BeforeEach
    void createCarSet()
    {
        elems = new HashSet<>();

        for (int i = 0; i < HashSet.INITIAL_BINS * 2 + 2; ++i)
        {
            elems.add(i);
        }
    }

    @DisplayName("Test addition")
    @Test
    void testAddition()
    {
        int size = elems.size();

        Assertions.assertTrue(elems.add(size));
        Assertions.assertEquals(size + 1, elems.size());

        Assertions.assertFalse(elems.add(size));
        Assertions.assertEquals(size + 1, elems.size());
    }

    @DisplayName("Test remove")
    @Test
    void testRemove()
    {
        int size = elems.size();
        int key = size - 1;

        Assertions.assertTrue(elems.remove(key));
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertFalse(elems.remove(key));
        Assertions.assertEquals(size - 1, elems.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        elems.clear();
        Assertions.assertEquals(0, elems.size());

        int key = 0;
        Assertions.assertTrue(elems.add(key));
        Assertions.assertTrue(elems.remove(key));
        Assertions.assertEquals(0, elems.size());
    }

    @DisplayName("Test NULL key")
    @Test
    void testNullCar()
    {
        int size = elems.size();

        Assertions.assertTrue(elems.add(null));
        Assertions.assertEquals(size + 1, elems.size());

        Assertions.assertTrue(elems.remove(null));
        Assertions.assertEquals(size, elems.size());
    }

    @DisplayName("Test contains")
    @Test
    void testContains()
    {
        int size = elems.size();

        Assertions.assertTrue(elems.contains(size - 1));
        Assertions.assertFalse(elems.contains(size));
    }

    @DisplayName("Test contains NULL")
    @Test
    void testContainsNull()
    {
        Assertions.assertTrue(elems.add(null));
        Assertions.assertTrue(elems.contains(null));
        Assertions.assertTrue(elems.remove(null));
        Assertions.assertFalse(elems.contains(null));
    }

    @DisplayName("Test for-each")
    @Test
    void testIter()
    {
        int size = elems.size();
        boolean []ids = new boolean[size];

        for (Integer e: elems)
        {
            Assertions.assertFalse(ids[e]);
            ids[e] = true;
        }

        for (int i = 0; i < ids.length; ++i)
        {
            Assertions.assertTrue(ids[i]);
        }
    }

    @DisplayName("Test iterator exceptions")
    @Test
    void testIterException()
    {
        int size = elems.size();
        final Iterator<Integer> i0 = elems.iterator();

        while (i0.hasNext())
        {
            i0.next();
        }

        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> i0.next()
        );

        final Iterator<Integer> i1 = elems.iterator();
        elems.add(size);

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i1.next()
        );

        final Iterator<Integer> i2 = elems.iterator();
        elems.remove(size);

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i2.next()
        );

        final Iterator<Integer> i3 = elems.iterator();
        elems.clear();

        Assertions.assertThrows(
            ConcurrentModificationException.class,
            () -> i3.next()
        );
    }
}
