package jupik.advance.mthres.finum;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;
import java.io.IOException;

public class RandomNumberFinder extends Thread implements NumberFinder
{
	private final GuessedNumber num;
	private final RandomGenerator rand;
	private final ReentrantLock lock;
	private final Condition cond;
	private boolean found;
	private int value;
	private double count;

	public RandomNumberFinder(GuessedNumber num, RandomGenerator rand)
	{
		this.num = num;
		this.rand = rand;

		lock = new ReentrantLock();
		cond = lock.newCondition();
		found = false;
		value = 0;
		count = 0;
	}

	public double count()
	{
		return count;
	}

	@Override
	public void run()
	{
		synchronized (rand)
		{
			while (true)
			{
				int v = rand.nextInt();

				++count;

				if (num.isEqual(v))
				{
					value = v;
					found = true;
					break;
				}
			}
		}

		lock.lock();
		try
		{
			cond.signalAll();
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public boolean await(long msecs) throws InterruptedException
	{
		lock.lock();
		try
		{
			return cond.await(msecs, TimeUnit.MILLISECONDS);
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public int value() throws IOException
	{
		if (!found)
		{
			throw new IOException("Not Ready");
		}

		return value;
	}
}
