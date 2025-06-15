package jupik.oop.inhov.wbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class WboxTest
{
	@Test
	void testProperties()
	{
		double h = 10;
		double l = 20;
		double w = 30;
		double m = 40;
		Wbox box = new Wbox(h, l, w, m);

		Assertions.assertEquals(h, box.height());
		Assertions.assertEquals(l, box.length());
		Assertions.assertEquals(w, box.width());
		Assertions.assertEquals(m, box.weight());
	}

	@Test
	void testEqualDimensions()
	{
		double d = 10;
		double m = 20;
		Wbox box = new Wbox(d, m);

		Assertions.assertEquals(d, box.height());
		Assertions.assertEquals(d, box.length());
		Assertions.assertEquals(d, box.width());
		Assertions.assertEquals(m, box.weight());
	}

	@Test
	void testDefaultDimensions()
	{
		double d = Wbox.DEFAULT_SIZE;
		double m = 20;
		Wbox box = new Wbox(m);

		Assertions.assertEquals(d, box.height());
		Assertions.assertEquals(d, box.length());
		Assertions.assertEquals(d, box.width());
		Assertions.assertEquals(m, box.weight());
	}

	@Test
	public void testEqual() {
		Wbox one = new Wbox(10, 20, 30, 40);
		Wbox other = new Wbox(10, 20, 30, 40);

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}

	@Test
	public void testNotEqual() {
		Wbox one = new Wbox(10, 20, 30, 30);
		Wbox other = new Wbox(10, 20, 30, 40);
		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNotEqualNull() {
		Wbox one = new Wbox(10);
		Wbox other = null;

		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testClone() {
		Wbox one = new Wbox(10, 20, 30, 40);
		Wbox other = (Wbox)one.clone();

		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}
}
