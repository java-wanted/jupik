package jupik.oop.inher.cafs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DomesticCatTest
{
	@Test
	void testProperties()
	{
		Cat cat = new DomesticCat();
		Assertions.assertEquals(false, cat.canEatHumans());
		Assertions.assertEquals(2, cat.eyes());
		Assertions.assertEquals(4, cat.legs());
	}
}
