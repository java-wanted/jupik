package jupik.oop.inhab.figs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShapeTest
{
	static class ZShape extends Shape
	{
		public ZShape(double a, double b)
		{
			super(a, b);
		}

		public double perimeter()
		{
			return 0;
		}
	}

	@Test
	void testValidProperties()
	{
		double a = 10;
		double b = 20;
		Shape s = new ZShape(a, b);

		Assertions.assertEquals(a, s.a());
		Assertions.assertEquals(b, s.b());
		Assertions.assertEquals(0, s.perimeter());
	}

	@Test
	public void testNotEqual() {
		Shape one = new ZShape(10, 20);
		Shape other = new ZShape(10, 20);

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNoClone() {
		Shape one = new ZShape(10, 20);

		Assertions.assertThrows(
			CloneNotSupportedException.class,
			() -> one.clone()
		);
	}
}
