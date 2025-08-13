package jupik.generics.parops.limov;

import jupik.generics.parms.pcols.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrackTest
{
    LinkedList<Integer> source;

    @BeforeEach
    void createList()
    {
        source = new LinkedList<>();

        for (int i = 0; i < 15; ++i)
        {
            source.add(i);
        }
    }

    void validateRange(LinkedList<Number> list, int first)
    {
        for (Number v: list)
        {
            Assertions.assertEquals(first++, v.intValue());
        }
    }

    @DisplayName("Test move to empty")
    @Test
    void testMove()
    {
        int size = source.size();
        LinkedList<Number> dest = new LinkedList<>();

        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size, dest.size());

        validateRange(dest, 0);
    }

    @DisplayName("Test move of empty")
    @Test
    void testMoveEmpty()
    {
        LinkedList<Number> dest = new LinkedList<>();

        Track.transfer(source, dest);
        int size = dest.size();

        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size, dest.size());

        validateRange(dest, 0);
    }

    @DisplayName("Test move to not empty")
    @Test
    void testMoveToNotEmpty()
    {
        int size = source.size();
        LinkedList<Number> dest = new LinkedList<>();

        for (int i = -size; i < 0; ++i)
        {
            dest.add(i);
        }

        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size * 2, dest.size());

        validateRange(dest, -size);
    }
}
