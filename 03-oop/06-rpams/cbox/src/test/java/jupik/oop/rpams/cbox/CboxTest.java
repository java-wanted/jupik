package jupik.oop.rpams.cbox;

import jupik.oop.parms.pbox.Pbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CboxTest {
	@Test
	public void testLesser() {
		Cbox one = new Cbox();
		Pbox other = new Pbox(){
			{
				setDimensions(10, 10, 20);
			}
		};
		Assertions.assertEquals(-1, one.compareTo(other));
	}

	@Test
	public void testEqual() {
		Cbox one = new Cbox(20);
		Pbox other = new Pbox(){
			{
				setDimensions(20, 20, 20);
			}
		};
		Assertions.assertEquals(0, one.compareTo(other));
	}

	@Test
	public void testGreater() {
		Cbox one = new Cbox(10, 10, 20);
		Pbox other = new Pbox(){
			{
				setDimensions(10, 10, 10);
			}
		};
		Assertions.assertEquals(1, one.compareTo(other));
	}
}
