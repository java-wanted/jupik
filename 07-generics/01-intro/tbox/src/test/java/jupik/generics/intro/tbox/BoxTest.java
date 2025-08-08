package jupik.generics.intro.tbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoxTest
{
    @DisplayName("Test constructor with parameter")
    @Test
    void testParam()
    {
        Box<String, Integer, Float> b1 = new Box<>("10", 10, 10f);

        Assertions.assertEquals("10", b1.first());
        Assertions.assertEquals(10, b1.second());
        Assertions.assertEquals(10f, b1.third());
    }
    

    @DisplayName("Test set operation")
    @Test
    void testSet()
    {
        Box<String, Integer, Float> b1 = new Box<>();

        b1.setFirst("10");
        b1.setSecond(10);
        b1.setThird(10f);

        Assertions.assertEquals("10", b1.first());
        Assertions.assertEquals(10, b1.second());
        Assertions.assertEquals(10f, b1.third());
    }

    @DisplayName("Test equals")
    @Test
    void testEquals()
    {
        Box<String, Integer, Float> b1 = new Box<>("10", 10, 10f);
        Box<String, Integer, Float> b2 = new Box<>("10", 10, 10f);

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());
    }

    @DisplayName("Test not equals")
    @Test
    void testNotEquals()
    {
        Box<String, Integer, Float> b1 = new Box<>("10", 10, 10f);
        Box<String, Integer, Float> b2 = new Box<>("11", 10, 10f);

        Assertions.assertNotEquals(b1, b2);

        Box<String, Integer, Float> b3 = new Box<>("10", 10, 10f);
        Box<String, Integer, Float> b4 = new Box<>("10", 11, 10f);

        Assertions.assertNotEquals(b3, b4);

        Box<String, Integer, Float> b5 = new Box<>("10", 10, 10f);
        Box<String, Integer, Float> b6 = new Box<>("10", 11, 10.1f);

        Assertions.assertNotEquals(b5, b6);
    }

    @DisplayName("Test equals NULL")
    @Test
    void testEqualsNull()
    {
        Box<String, Integer, Float> b1 = new Box<>();
        Box<String, Integer, Float> b2 = new Box<>();

        Assertions.assertEquals(b1, b2);
    }

    @DisplayName("Test not equals NULL")
    @Test
    void testNotEqualsNull()
    {
        Box<String, Integer, Float> b1 = new Box<>(null, null, 10.1f);
        Box<String, Integer, Float> b2 = new Box<>();

        Assertions.assertNotEquals(b1, b2);
    }

    float numberIf(Object o)
    {
        return o instanceof Number v ? v.floatValue() : 0f;
    }

    @DisplayName("Test sum of numbers")
    @Test
    void testSumOfNumbers()
    {
        Box<String, Integer, Float> b1 = new Box<>("10", 10, 10f);
        Box<String, Integer, Float> b2 = new Box<>("10", 11, 10.1f);
        float exp = 10 + 10f + 11 + 10.1f;
        float sum = 0;

        sum += numberIf(b1.first());
        sum += numberIf(b1.second());
        sum += numberIf(b1.third());
        sum += numberIf(b2.first());
        sum += numberIf(b2.second());
        sum += numberIf(b2.third());

        Assertions.assertEquals(exp, sum);
    }
}
