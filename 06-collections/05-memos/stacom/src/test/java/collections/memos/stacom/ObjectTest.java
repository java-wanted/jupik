package jupik.collections.memos.stacom;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ObjectTest
{
    @DisplayName("Test equality")
    @ParameterizedTest(name = " of object of {0}")
    @CsvSource({"0", "1"})
    void testEqual(int number)
    {
        Object a = new Object(number);
        Object b = a;

        Assertions.assertTrue(b == a);
    }

    @DisplayName("Test not equality")
    @ParameterizedTest(name = " of objects of {0}")
    @CsvSource({"0", "1"})
    void testNotEqual(int number)
    {
        Object a = new Object(number);
        Object b = new Object(number);

        Assertions.assertFalse(b == a);
    }
}
