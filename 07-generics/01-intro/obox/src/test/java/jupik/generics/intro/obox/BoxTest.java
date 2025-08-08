package jupik.generics.intro.obox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoxTest
{
    @DisplayName("Test default constructor")
    @Test
    void testDflt()
    {
        Box b1 = new Box();

        Assertions.assertNull(b1.value());
    }

    @DisplayName("Test constructor with parameter")
    @Test
    void testParam()
    {
        Box b1 = new Box(10);

        Assertions.assertEquals(10, (int)b1.value());
    }
    

    @DisplayName("Test set operation")
    @Test
    void testSet()
    {
        Box b1 = new Box();

        b1.setValue(10);
        Assertions.assertEquals(10, (int)b1.value());

        b1.setValue("10");
        Assertions.assertEquals("10", (String)b1.value());
    }

    @DisplayName("Test equals")
    @Test
    void testEquals()
    {
        Box b1 = new Box(10);
        Box b2 = new Box(10);

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());

        b1.setValue("10");
        b2.setValue("10");

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());
    }


    @DisplayName("Test not equals")
    @Test
    void testNotEquals()
    {
        Box b1 = new Box(10);
        Box b2 = new Box(20);

        Assertions.assertNotEquals(b1, b2);

        b2.setValue("10");
        Assertions.assertNotEquals(b1, b2);

        b1.setValue("20");
        Assertions.assertNotEquals(b1, b2);
    }
}
