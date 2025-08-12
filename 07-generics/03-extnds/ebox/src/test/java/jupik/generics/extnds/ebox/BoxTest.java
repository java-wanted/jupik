package jupik.generics.extnds.ebox;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoxTest
{
    final double EPS = 1.0e-7;
    final int N = 10;
    final double meaN = (N - 1.0) / 2.0;
    final Integer []intN = new Integer[N];
    final Float []floN = new Float[N];

    @BeforeEach
    void setNums()
    {
        for (int i = 0; i < N; ++i)
        {
            intN[i] = i;
            floN[i] = (float)i;
        }
    }

    @DisplayName("Test constructor")
    @Test
    void testInit()
    {
        Box<Integer> b1 = new Box<>(intN);

        Assertions.assertEquals(meaN, b1.mean(), EPS);
    }

    @DisplayName("Test set operation")
    @Test
    void testSet()
    {
        Box<Integer> b1 = new Box<>(new Integer[0]);

        b1.set(Arrays.asList(intN));
        Assertions.assertEquals(meaN, b1.mean(), EPS);
    }

    @DisplayName("Test ints equal")
    @Test
    void testEquals()
    {
        Box<Integer> b1 = new Box<>(intN);
        Box<Integer> b2 = new Box<>(intN);

        Assertions.assertEquals(b1, b2);
    }

    @DisplayName("Test ints comparison")
    @Test
    void testCompareTo()
    {
        Box<Integer> b1 = new Box<>(intN);
        Box<Integer> b2 = new Box<>(intN);

        Assertions.assertEquals(0, b1.compareTo(b2));
    }

    @DisplayName("Test set ints and floats operation")
    @Test
    void testSetFloats()
    {
        Box<Number> b1 = new Box<>(new Integer[0]);

        b1.set(Arrays.asList(intN));
        Assertions.assertEquals(meaN, b1.mean(), EPS);

        b1.set(Arrays.asList(floN));
        Assertions.assertEquals(meaN, b1.mean(), EPS);

    }

    @DisplayName("Test floats and ints equal")
    @Test
    void TestFloatEquals()
    {
        Box<Integer> b1 = new Box<>(intN);
        Box<Float> b2 = new Box<>(floN);

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b2, b1);
    }

    @DisplayName("Test floats and ints comparison")
    @Test
    void TestCompareToFloats()
    {
        Box<Integer> b1 = new Box<>(intN);
        Box<Float> b2 = new Box<>(floN);

        Assertions.assertEquals(0, b1.compareTo(b2));
        Assertions.assertEquals(0, b1.compareTo(b2));
    }
}
