package jupik.oop.rpams.dbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DboxTest {
	@Test
	public void testDimensionsDoubled() {
		int h = 10;
		int l = 20;
		int w = 30;
		Dbox ebox = new Dbox(h * 2, l * 2, w * 2);
		Dbox dbox = (new Dbox(h, l, w)).doubleDimensions();
		Assertions.assertTrue(ebox.equals(dbox));
	}
}
