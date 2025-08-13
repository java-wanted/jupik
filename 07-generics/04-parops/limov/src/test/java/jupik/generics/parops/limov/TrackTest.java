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

    @DisplayName("Test move to empty")
    @Test
    void testMove()
    {
        int size = source.size();
        LinkedList<Integer> dest = new LinkedList<>();

        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size, dest.size());

        int i = 0;
        for (Integer v: dest)
        {
            Assertions.assertEquals(i++, v);
        }
    }

    @DisplayName("Test move empty")
    @Test
    void testMoveEmpty()
    {
        LinkedList<Integer> dest = source;
        int size = dest.size();

        source = new LinkedList<>();
        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size, dest.size());

        int i = 0;

        for (Integer v: dest)
        {
            Assertions.assertEquals(i++, v);
        }
    }

    @DisplayName("Test move to not empty")
    @Test
    void testMoveToNotEmpty()
    {
        int size = source.size();
        LinkedList<Integer> dest = new LinkedList<>();

        for (int i = -size; i < 0; ++i)
        {
            dest.add(i);
        }

        Track.transfer(source, dest);

        Assertions.assertEquals(0, source.size());
        Assertions.assertEquals(size * 2, dest.size());

        int i = -size;

        for (Integer v: dest)
        {
            Assertions.assertEquals(i++, v);
        }
    }
}
