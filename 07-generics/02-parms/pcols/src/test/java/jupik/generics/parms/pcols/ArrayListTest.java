package jupik.generics.parms.pcols;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayListTest
{
    List<Integer> elems;

    @BeforeEach
    void createList()
    {
        elems = new ArrayList<>();

        for (int i = 0; i < 15; ++i)
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
        Assertions.assertEquals(size, elems.get(size));
    }

    @DisplayName("Test addition at tail")
    @Test
    void testAdditionAtTail()
    {
        int size = elems.size();

        elems.add(size, size);
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(size, elems.get(size));
    }

    @DisplayName("Test addition at head")
    @Test
    void testAdditionAtHead()
    {
        int size = elems.size();

        elems.add(size, 0);
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(size, elems.get(0));
    }

    @DisplayName("Test addition at middle")
    @Test
    void testAdditionAtMiddle()
    {
        int size = elems.size();

        elems.add(size, size / 2);
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(size, elems.get(size / 2));
    }

    @DisplayName("Test exception on get")
    @Test
    void testGetAtException()
    {
        int size = elems.size();

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> elems.get(size)
        );
    }

    @DisplayName("Test remove at tail")
    @Test
    void testRemoveAtTail()
    {
        int size = elems.size();

        elems.removeAt(size - 1);
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(size - 2, elems.get(size - 2));
    }

    @DisplayName("Test remove at head")
    @Test
    void testRemoveAtHead()
    {
        int size = elems.size();

        elems.removeAt(0);
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(1, elems.get(0));
    }

    @DisplayName("Test remove at middle")
    @Test
    void testRemoveAtMiddle()
    {
        int size = elems.size();

        elems.removeAt(size / 2);
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(size / 2 + 1, elems.get(size / 2));
    }

    @DisplayName("Test exception on remove at")
    @Test
    void testRemoveAtException()
    {
        int size = elems.size();

        Assertions.assertThrows(
            IndexOutOfBoundsException.class, () -> elems.removeAt(size)
        );
    }

    @DisplayName("Test remove of last")
    @Test
    void testRemoveLast()
    {
        int size = elems.size();
        Integer elem = size - 1;

        Assertions.assertTrue(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(size - 2, elems.get(size - 2));

        Assertions.assertFalse(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
    }

    @DisplayName("Test remove of first")
    @Test
    void testRemoveFirst()
    {
        int size = elems.size();
        Integer elem = 0;

        Assertions.assertTrue(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(1, elems.get(0));

        Assertions.assertFalse(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
    }

    @DisplayName("Test remove of middle")
    @Test
    void testRemoveMiddle()
    {
        int size = elems.size();
        Integer elem = size / 2;

        Assertions.assertTrue(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
        Assertions.assertEquals(size / 2 + 1, elems.get(size / 2));

        Assertions.assertFalse(elems.remove(elem));
        Assertions.assertEquals(size - 1, elems.size());
    }

    @DisplayName("Test clear")
    @Test
    void testClear()
    {
        Integer elem = elems.get(0);

        elems.clear();
        Assertions.assertEquals(0, elems.size());

        Assertions.assertTrue(elems.add(elem));
        Assertions.assertTrue(elems.remove(elem));
        Assertions.assertEquals(0, elems.size());
    }

    @DisplayName("Test NULL elem")
    @Test
    void testNullCar()
    {
        int size = elems.size();

        Assertions.assertTrue(elems.add(null));
        Assertions.assertEquals(size + 1, elems.size());
        Assertions.assertEquals(null, elems.get(size));

        Assertions.assertTrue(elems.remove(null));
        Assertions.assertEquals(size, elems.size());
        Assertions.assertNotEquals(null, elems.get(size - 1));
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
        int index = 0;

        for (Integer elem: elems)
        {
            Assertions.assertEquals(index++, elem);
        }
    }
}
