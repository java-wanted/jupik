package jupik.advance.mthres.finum;

import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomNumberFinderTest
{
	static class TestGenerator implements RandomGenerator
	{
		long value;
		long max;

		TestGenerator(long origin, long max)
		{
			this.value = origin;
			this.max = max;
		}

		@Override
		public int nextInt()
		{
			return (int)nextLong();
		}

		@Override
		public long nextLong()
		{
			if (value > max)
			{
				throw new RuntimeException();
			}

			return value++;
		}
	}

	static class TestNumber implements GuessedNumber
	{
		int min;
		int max;
		int value;

		TestNumber(int min, int max, int value)
		{
			this.min = min;
			this.max = max;
			this.value = value;
		}

		@Override
		public int min()
		{
			return min;
		}

		@Override
		public int max()
		{
			return max;
		}

		@Override
		public boolean isEqual(int value)
		{
			return value == this.value;
		}
	}

	static class TestWaiter extends Thread
	{
		NumberFinder finder;
		long msec;
		boolean ready;

		TestWaiter(NumberFinder finder, long msec)
		{
			this.finder = finder;
			this.msec = msec;
			ready = false;
		}

		@Override
		public void run()
		{
			try
			{
				ready = finder.await(msec);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException();
			}
		}
	}


	@Test
	void testFound()
	{
		TestNumber number = new TestNumber(10, 30, 20);
		TestGenerator random = new TestGenerator(number.min, number.max);
		RandomNumberFinder finder = new RandomNumberFinder(number, random);
		TestWaiter waiter = new TestWaiter(finder, 2000);
		boolean joined = false;
		boolean ready = false;
		int value = 0;

		waiter.start();
		finder.start();

		try
		{
			finder.join();
			waiter.join();
			joined = true;
		}
		catch (InterruptedException e)
		{
		}

		Assertions.assertTrue(joined);
		Assertions.assertTrue(waiter.ready);

		try
		{
			value = finder.value();
			ready = true;
		}
		catch (IOException e)
		{
		}

		Assertions.assertTrue(ready);
		Assertions.assertEquals(number.value, value);
		Assertions.assertEquals(number.value - number.min + 1, finder.count(), 0.1e-7);
	}

	@Test
	void testNotReady()
	{
		TestNumber number = new TestNumber(0, 0, 0);
		TestGenerator random = new TestGenerator(0, 0);
		final RandomNumberFinder finder = new RandomNumberFinder(
			number, random
		);
		Throwable e = Assertions.assertThrows(
			IOException.class,
			() -> finder.value()
		);

		Assertions.assertEquals("Not Ready", e.getMessage());
	}
}
