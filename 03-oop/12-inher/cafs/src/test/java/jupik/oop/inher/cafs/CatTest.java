package jupik.oop.inher.cafs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CatTest
{
	@Test
	void testProperties()
	{
		Cat cat = new Cat(true, 2, 3);
		Assertions.assertEquals(true, cat.canEatHumans());
		Assertions.assertEquals(2, cat.eyes());
		Assertions.assertEquals(3, cat.legs());
	}
}
