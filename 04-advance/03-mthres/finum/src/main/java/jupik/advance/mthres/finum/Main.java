package jupik.advance.mthres.finum;

import java.util.Random;

public class Main
{
	static class Number implements GuessedNumber
	{
		int min;
		int max;
		int value;

		Number(int min, int max, Random random)
		{
			this.min = min;
			this.max = max;
			this.value = random.nextInt(min, max);
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

	public static void main(String []argv)
	{
		int min = 0;
		int max = 1000000000;

		Random random = new Random();
		final Number number = new Number(min, max, random);

		final RandomNumberFinder finder = new RandomNumberFinder(
			number, random
		);
		Thread monitor = new Thread(new Runnable(){
			@Override
			public void run()
			{
				System.out.printf(
					"Start to guess a number from %d to %d: ",
					min, max
				);
				System.out.flush();

				finder.start();

				try
				{
					int count = 0;

					do
					{
						System.out.printf("%d ", count++);
						System.out.flush();
					}
					while (!finder.await(1000));

					System.out.printf(
						"\nThe number is %d (found in %e tries).\n",
						 finder.value(), finder.count()
					);
				}
				catch (Exception e)
				{
					System.out.printf("Failed to find the guessed number: %s\n", e);
					System.exit(1);
				}
			}
		});
		monitor.start();

		try
		{
			finder.join();
			monitor.join();
		}
		catch (InterruptedException e)
		{
		}
	}
}
