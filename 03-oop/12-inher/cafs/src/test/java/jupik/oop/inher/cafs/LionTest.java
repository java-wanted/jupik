package jupik.oop.inher.cafs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LionTest
{
	@Test
	void testProperties()
	{
		Cat cat = new Lion();
		Assertions.assertEquals(true, cat.canEatHumans());
		Assertions.assertEquals(2, cat.eyes());
		Assertions.assertEquals(4, cat.legs());
	}
}
