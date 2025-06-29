package jupik.level2.junit.ucalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UcalcTest
{
	static float EPS = 1.e-7f;

	static record TD(double a, double b)
	{
		TD(double a)
		{
			this(a, a);
		}
	}

	@Test
	void testAddition()
	{
		TD []td = {
			new TD(1, 1.1),
			new TD(-1, 3.1),
		};

		for (TD d: td)
		{
			Assertions.assertEquals(d.a + d.b, Ucalc.add(d.a, d.b));
		}
	}

	@Test
	void testSubtraction()
	{
		TD []td = {
			new TD(1, 1.1),
			new TD(1, -1.1),
		};

		for (TD d: td)
		{
			Assertions.assertEquals(d.a - d.b, Ucalc.sub(d.a, d.b));
		}
	}

	@Test
	void testMultiplication()
	{
		TD []td = {
			new TD(1, 1.1),
			new TD(2, 1.1),
		};

		for (TD d: td)
		{
			Assertions.assertEquals(d.a * d.b, Ucalc.mul(d.a, d.b));
		}
	}

	@Test
	void testDivision()
	{
		TD []td = {
			new TD(2.2, 1.1),
			new TD(-3.3, -1.1),
			new TD(-1.0, 0.0),
		};

		for (TD d: td)
		{
			Assertions.assertEquals(d.a / d.b, Ucalc.div(d.a, d.b));
		}
	}

	@Test
	void testSquare()
	{
		TD []td = {
			new TD(2.2),
			new TD(-1.0),
		};

		for (TD d: td)
		{
			Assertions.assertEquals(d.a * d.a, Ucalc.pow2(d.a));
		}
	}
}
