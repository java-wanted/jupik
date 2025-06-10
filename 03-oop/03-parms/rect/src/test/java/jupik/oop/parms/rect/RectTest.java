package jupik.oop.parms.rect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RectTest {
	static float EPS = 1.e-7f;

	static record TD(float l, float w, float a)
	{
	};

	@Test
	public void testArea() {
		TD []td = {
			new TD(1.1f, 2.2f, 2.42f),
			new TD(2.2f, 1.1f, 2.42f),
		};

		Rect r = new Rect();

		for (TD d: td)
		{
			r.setDimensions(d.l, d.w);
			Assertions.assertEquals(d.a, r.area(), EPS);
		}
	}
}
