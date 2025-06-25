package jupik.oop.inhab.figs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RectangleTest
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
		Shape s = new Rectangle(a, b);

		Assertions.assertEquals(a, s.a());
		Assertions.assertEquals(b, s.b());
		Assertions.assertEquals(a + a + b + b, s.perimeter());
	}

	@Test
	void testInvalidProperties()
	{
		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Rectangle(0, 1)
		);

		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Rectangle(1, 0)
		);
	}

	@Test
	public void testEqual() {
		Shape one = new Rectangle(10, 20);
		Shape other = new Rectangle(10, 20);

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
		Assertions.assertEquals(one.perimeter(), other.perimeter());
	}

	@Test
	public void testNotEqual() {
		Shape one = new Rectangle(10, 20);
		Shape other = new Rectangle(10, 10);

		Assertions.assertFalse(one.equals(other));
		Assertions.assertNotEquals(one.perimeter(), other.perimeter());
	}

	@Test
	public void testNotEqualNull() {
		Shape one = new Rectangle(10, 20);
		Shape other = null;

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNotEqualZShape() {
		Shape one = new Rectangle(10, 20);
		Shape other = new ZShape(10, 20);

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		Shape one = new Rectangle(10, 20);
		Shape other = (Shape)one.clone();

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
		Assertions.assertEquals(one.perimeter(), other.perimeter());
	}
}
