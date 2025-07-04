package jupik.collections.equas.hacom;

import jupik.collections.arlis.capar.Car;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CarsTest
{
    @DisplayName("Test non equality")
    @ParameterizedTest(name = " of CarA {1} #{0} and CarB {1} #{0}")
    @CsvSource({"0,A", "1,B"})
    void testCarsEqual(int number, String brand)
    {
        Car a = new CarA(number, brand);
        Car b = new CarB(number, brand);

        Assertions.assertNotEquals(a, b);
    }
}
