package jupik.oop.amods.abox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BoxTest
{
	@Test
	void testDimensions()
	{
		double h = 10;
		double l = 20;
		double w = 30;
		Box box = new Box(h, l, w);

		Assertions.assertEquals(h, box.height());
		Assertions.assertEquals(l, box.length());
		Assertions.assertEquals(w, box.width());

		Assertions.assertEquals(h * l * w, box.volume());
	}

	@Test
	void testEqualDimensions()
	{
		double d = 10;
		Box box = new Box(d);

		Assertions.assertEquals(d, box.height());
		Assertions.assertEquals(d, box.length());
		Assertions.assertEquals(d, box.width());

		Assertions.assertEquals(d * d * d, box.volume());
	}

	@Test
	void testDefaultDimensions()
	{
		double d = Box.DEFAULT_SIZE;
		Box box = new Box(d);

		Assertions.assertEquals(d, box.height());
		Assertions.assertEquals(d, box.length());
		Assertions.assertEquals(d, box.width());

		Assertions.assertEquals(d * d * d, box.volume());
	}

	@Test
	public void testEqual() {
		Box one = new Box(10, 20, 30);
		Box other = new Box(10, 20, 30);

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}

	@Test
	public void testNotEqual() {
		Box one = new Box(10, 20, 20);
		Box other = new Box(10, 20, 30);
		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNotEqualNull() {
		Box one = new Box(10, 20, 20);
		Box other = null;

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testClone() {
		Box one = new Box(10, 10, 30);
		Box other = (Box)one.clone();

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}
}
