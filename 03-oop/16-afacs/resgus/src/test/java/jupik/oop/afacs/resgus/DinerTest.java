package jupik.oop.afacs.resgus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DinerTest
{
	static class TWaiter implements Waiter
	{
		String dish = "";
		int count = 0;

		@Override
		public void bring(String dish)
		{
			this.dish = dish;
			++this.count;
		}
	}

	TWaiter waiter;

	@BeforeEach
	void setWaiter()
	{
		waiter = new TWaiter();
	}

	@Test
	void testOrder()
	{
		String []dish = {
			"Dish1",
			"Dish2"
		};
		Diner diner = new Diner()
		{
		};

		for (String d: dish)
		{
			diner.order(waiter, d);
			Assertions.assertEquals(waiter.dish, d);
		}

		Assertions.assertEquals(dish.length, waiter.count);
	}
}
