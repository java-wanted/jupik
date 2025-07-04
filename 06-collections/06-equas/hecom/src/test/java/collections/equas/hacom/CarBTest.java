package jupik.collections.equas.hacom;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CarBTest
{
    @DisplayName("Test equality")
    @ParameterizedTest(name = " of {1} #{0} and {1} #{0}")
    @CsvSource({"0,A", "1,B"})
    void testCarsEqual(int number, String brand)
    {
        Car a = new CarB(number, brand);
        Car b = new CarB(number, brand);

        Assertions.assertEquals(a, b);
        Assertions.assertEquals(a.hashCode(), b.hashCode());
    }

    @DisplayName("Test non equality")
    @ParameterizedTest(name = " of {1} #{0} and {3}, #{2}")
    @CsvSource({"0,A,1,A", "0,A,0,B", "0,A,1,B"})
    void testCarsNotEqual(int n1, String b1, int n2, String b2)
    {
        Car a = new CarB(n1, b1);
        Car b = new CarB(n2, b2);

        Assertions.assertNotEquals(a, b);
    }
}
