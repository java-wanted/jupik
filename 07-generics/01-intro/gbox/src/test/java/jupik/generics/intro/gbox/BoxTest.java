package jupik.generics.intro.gbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoxTest
{
    @DisplayName("Test default constructor")
    @Test
    void testDflt()
    {
        Box<Integer> b1 = new Box<>();

        Assertions.assertNull(b1.value());
    }

    @DisplayName("Test constructor with parameter")
    @Test
    void testParam()
    {
        Box<Integer> b1 = new Box<>(10);

        Assertions.assertEquals(10, b1.value());
    }
    

    @DisplayName("Test set operation")
    @Test
    void testSet()
    {
        Box<Integer> b1 = new Box<>();
        Box<String> b2 = new Box<>();

        b1.setValue(10);
        Assertions.assertEquals(10, b1.value());

        b2.setValue("10");
        Assertions.assertEquals("10", b2.value());
    }

    @DisplayName("Test equals")
    @Test
    void testEquals()
    {
        Box<Integer> b1 = new Box<>(10);
        Box<Integer> b2 = new Box<>(10);

        Assertions.assertEquals(b1, b2);
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());

        Box<String> b3 = new Box<>("10");
        Box<String> b4 = new Box<>("10");

        Assertions.assertEquals(b3, b4);
        Assertions.assertEquals(b3.hashCode(), b4.hashCode());
    }

    @DisplayName("Test not equals")
    @Test
    void testNotEquals()
    {
        Box<Integer> b1 = new Box<>(10);
        Box<Integer> b2 = new Box<>(20);

        Assertions.assertNotEquals(b1, b2);

        Box<String> b3 = new Box<>("10");
        Box<String> b4 = new Box<>("20");

        Assertions.assertNotEquals(b3, b4);
    }

    @DisplayName("Test equals NULL")
    @Test
    void testEqualsNull()
    {
        Box<Integer> b1 = new Box<>();
        Box<Integer> b2 = new Box<>();

        Assertions.assertEquals(b1, b2);
    }

    @DisplayName("Test not equals NULL")
    @Test
    void testNotEqualsNull()
    {
        Box<Integer> b1 = new Box<>(10);
        Box<Integer> b2 = new Box<>();

        Assertions.assertNotEquals(b1, b2);
    }
}
