package jupik.level2.punit.pcalc;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PcalcTest
{
	static float EPS = 1.e-7f;

	static Stream<Arguments> getAdditionOperands() {
		return Stream.of(
			Arguments.of(1, 1.1),
			Arguments.of(2, 1.1)
		);
	}

	@DisplayName("Test addition of ")
	@ParameterizedTest(name = "{0} and {1}")
	@MethodSource("getAdditionOperands")
	void testAddition(double a, double b)
	{
		Assertions.assertEquals(a + b, Pcalc.add(a, b), EPS);
	}

	@DisplayName("Test addition of strings ")
	@ParameterizedTest(name = "\"{0}\" and \"{1}\"")
	@MethodSource("getAdditionOperands")
	void testStringAddition(double a, double b)
	{
		Assertions.assertEquals(
			a + b, Pcalc.add(Double.toString(a), Double.toString(b)), EPS
		);
	}

	@DisplayName("Test a format exception on addition of strings ")
	@ParameterizedTest(name = "\"{0}\" and \"{1}\"")
	@CsvSource({"a,1.1", "2,a"})
	void testStringAdditionFormatException(String a, String b)
	{
		Assertions.assertThrows(
			NumberFormatException.class, () -> Pcalc.add(a, b)
		);
	}

	static Stream<Arguments> getSubtractionOperands() {
		return Stream.of(
			Arguments.of(1, 1.1),
			Arguments.of(2, 1.1)
		);
	}

	@DisplayName("Test subtraction of ")
	@ParameterizedTest(name = "{1} from {0}")
	@MethodSource("getSubtractionOperands")
	void testSubtraction(double a, double b)
	{
		Assertions.assertEquals(a - b, Pcalc.sub(a, b), EPS);
	}

	@DisplayName("Test subtraction of strings ")
	@ParameterizedTest(name = "\"{1}\" from \"{0}\"")
	@MethodSource("getSubtractionOperands")
	void testStringSubtraction(double a, double b)
	{
		Assertions.assertEquals(
			a - b, Pcalc.sub(Double.toString(a), Double.toString(b)), EPS
		);
	}

	@DisplayName("Test a format exception on subtraction of strings ")
	@ParameterizedTest(name = "\"{1}\" from \"{0}\"")
	@CsvSource({"a,1.1", "2,a"})
	void testStringSubtractionFormatException(String a, String b)
	{
		Assertions.assertThrows(
			NumberFormatException.class, () -> Pcalc.sub(a, b)
		);
	}

	static Stream<Arguments> getMultiplicationOperands() {
		return Stream.of(
			Arguments.of(1, 1.1),
			Arguments.of(2, 1.1)
		);
	}

	@DisplayName("Test multiplication of ")
	@ParameterizedTest(name = "{0} and {1}")
	@MethodSource("getMultiplicationOperands")
	void testMultiplication(double a, double b)
	{
		Assertions.assertEquals(a * b, Pcalc.mul(a, b), EPS);
	}

	@DisplayName("Test multiplication of strings ")
	@ParameterizedTest(name = "\"{0}\" and \"{1}\"")
	@MethodSource("getMultiplicationOperands")
	void testStringMultiplication(double a, double b)
	{
		Assertions.assertEquals(
			a * b, Pcalc.mul(Double.toString(a), Double.toString(b)), EPS
		);
	}

	@DisplayName("Test a format exception on multiplication of strings ")
	@ParameterizedTest(name = "\"{0}\" and \"{1}\"")
	@CsvSource({"a,1.1", "2,a"})
	void testStringMultiplicationFormatException(String a, String b)
	{
		Assertions.assertThrows(
			NumberFormatException.class, () -> Pcalc.mul(a, b)
		);
	}

	static Stream<Arguments> getDivisionOperands() {
		return Stream.of(
			Arguments.of(2.2, 1.1),
			Arguments.of(-3.3, -1.1),
			Arguments.of(-1.0, 0.0)
		);
	}

	@DisplayName("Test division of ")
	@ParameterizedTest(name = "{0} by {1}")
	@MethodSource("getDivisionOperands")
	void testDivision(double a, double b)
	{
		Assertions.assertEquals(a / b, Pcalc.div(a, b), EPS);
	}

	@DisplayName("Test division of strings ")
	@ParameterizedTest(name = "\"{0}\" by \"{1}\"")
	@MethodSource("getDivisionOperands")
	void testStringDivision(double a, double b)
	{
		Assertions.assertEquals(
			a / b, Pcalc.div(Double.toString(a), Double.toString(b)), EPS
		);
	}

	@DisplayName("Test a format exception on division of strings ")
	@ParameterizedTest(name = "\"{0}\" by \"{1}\"")
	@CsvSource({"a,1.1", "2,a"})
	void testStringDivisionFormatException(String a, String b)
	{
		Assertions.assertThrows(
			NumberFormatException.class, () -> Pcalc.div(a, b)
		);
	}

	static Stream<Arguments> getSquareOperands() {
		return Stream.of(
			Arguments.of(2.2),
			Arguments.of(-1.0)
		);
	}

	@DisplayName("Test power 2 of ")
	@ParameterizedTest(name = "{0}")
	@MethodSource("getSquareOperands")
	void testSquare(double a)
	{
		Assertions.assertEquals(a * a, Pcalc.pow2(a), EPS);
	}

	@DisplayName("Test power 2 of a string ")
	@ParameterizedTest(name = "\"{0}\"")
	@MethodSource("getSquareOperands")
	void testStringSquare(double a)
	{
		Assertions.assertEquals(
			a * a, Pcalc.pow2(Double.toString(a)), EPS
		);
	}

	@DisplayName("Test a format exception on power 2 of a string ")
	@ParameterizedTest(name = "\"{0}\"")
	@CsvSource({"a"})
	void testStringSquareFormatException(String a)
	{
		Assertions.assertThrows(
			NumberFormatException.class, () -> Pcalc.pow2(a)
		);
	}
}
