package jupik.oop.inhab.figs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTest
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
		double b = 15;
		double c = 20;
		Shape s = new Triangle(a, b, c);

		Assertions.assertEquals(a, s.a());
		Assertions.assertEquals(b, s.b());
		Assertions.assertEquals(c, ((Triangle)s).c());
		Assertions.assertEquals(a + b + c, s.perimeter());
	}

	@Test
	void testInvalidProperties()
	{
		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Triangle(10, 15, 0)
		);

		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Triangle(30, 15, 15)
		);

		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Triangle(10, 30, 20)
		);

		Assertions.assertThrows(
			IllegalArgumentException.class,
			() -> new Triangle(10, 15, 25)
		);
	}

	@Test
	public void testEqual() {
		Shape one = new Triangle(10, 15, 20);
		Shape other = new Triangle(10, 15, 20);

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
		Assertions.assertEquals(one.perimeter(), other.perimeter());
	}

	@Test
	public void testNotEqual() {
		Shape one = new Triangle(10, 15, 20);
		Shape other = new Triangle(10, 15, 10);

		Assertions.assertFalse(one.equals(other));
		Assertions.assertNotEquals(one.perimeter(), other.perimeter());
	}

	@Test
	public void testNotEqualNull() {
		Shape one = new Triangle(10, 15, 20);
		Shape other = null;

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNotEqualZShape() {
		Shape one = new Triangle(10, 15, 20);
		Shape other = new ZShape(10, 15);

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		Shape one = new Triangle(10, 15, 20);
		Shape other = (Shape)one.clone();

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
		Assertions.assertEquals(one.perimeter(), other.perimeter());
	}
}
