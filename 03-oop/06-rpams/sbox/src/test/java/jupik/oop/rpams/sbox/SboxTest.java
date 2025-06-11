package jupik.oop.rpams.sbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SboxTest {
	@Test
	public void testEqual() {
		Sbox one = new Sbox(10, 20, 30);
		Sbox other = new Sbox(10, 20, 30);
		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}

	@Test
	public void testNotEqual() {
		Sbox one = new Sbox(10, 20, 20);
		Sbox other = new Sbox(10, 20, 30);
		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testNotEqualNull() {
		Sbox one = new Sbox(10, 20, 20);
		Sbox other = null;
		Assertions.assertFalse(one.equals(other));
	}

	@Test
	public void testClone() {
		Sbox one = new Sbox(10, 10, 30);
		Sbox other = (Sbox)one.clone();
		Assertions.assertTrue(one.equals(other));
		Assertions.assertEquals(one.hashCode(), other.hashCode());
	}
}
