package jupik.multithreading.mqueue.exque;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner implements Runnable
{
    protected ExecutorService pool;
    protected Mqueue<Runnable> exque;
    protected boolean completed;

    public Runner(ExecutorService pool, Mqueue<Runnable> exque)
    {
        if (pool == null || exque == null)
        {
            throw new IllegalArgumentException();
        }

        this.pool = pool;
        this.exque = exque;
        this.completed = false;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Runnable r = exque.remove();

                if (r == null)
                {
                    break;
                }

                pool.execute(r);
            }

            pool.shutdown();

            while (!pool.awaitTermination(10000, TimeUnit.MILLISECONDS))
            {
            }

            completed = true;
        }
        catch (InterruptedException e)
        {
            pool.shutdownNow();
        }

        while (true)
        {
            try
            {
                if (pool.awaitTermination(10000, TimeUnit.MILLISECONDS))
                {
                    break;
                }
            }
            catch (InterruptedException g)
            {
            }
        }
    }
}
