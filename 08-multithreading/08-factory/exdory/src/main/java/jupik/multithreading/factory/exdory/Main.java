package jupik.multithreading.factory.exdory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{
    static abstract class Latchable implements Runnable
    {
        CountDownLatch latch;

        Latchable(CountDownLatch latch)
        {
            this.latch = latch;
        }

        abstract void execute() throws InterruptedException;

        @Override
        public void run()
        {
            try
            {
                execute();
            }
            catch (InterruptedException e)
            {
            }
            finally
            {
                latch.countDown();
            }
        }
    }

    static class Emuloader<T> extends Latchable
    {
        T value;
        T result;

        Emuloader(CountDownLatch latch, T value)
        {
            super(latch);

            this.value = value;
            this.result = null;
        }

        void execute() throws InterruptedException
        {
            Thread.sleep(5000);
            result = value;
        }
    }

    static class Pointer implements Runnable
    {
        public void run()
        {
            try
            {
                for (int i = 0;; ++i)
                {
                    System.out.printf(".");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
            }
            finally
            {
                System.out.printf("\n");
            }
        }
    }

    public static void main(String []argv)
    {
        CountDownLatch latch= new CountDownLatch(2);
        Emuloader<String> name = new Emuloader<String>(latch, "Saarah");
        Emuloader<Integer> age = new Emuloader<Integer>(latch, 90);
        Runnable []jobs = {name, age, new Pointer()};
        ExecutorService pool = Executors.newFixedThreadPool(3);
        boolean interrupted = false;

        for (Runnable j: jobs)
        {
            pool.execute(j);
        }

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            interrupted = false;
        }

        if (!interrupted)
        {
            if (name.result == null && age.result == null)
            {
                System.out.printf("Failed to load\n");
            }
            else
            {
                System.out.printf(
                    "Name is %s, Age is %d", name.result, age.result
                );
            }
        }

        pool.shutdownNow();
        boolean done = false;

        try
        {
            done = pool.awaitTermination(200, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
        }

        if (!done)
        {
            System.err.printf("Failed to interrupt\n");
            System.exit(1);
        }
        else if (interrupted)
        {
            System.out.printf("Interrupted\n");
        }
        else
        {
            System.out.printf("Done\n");
        }
    }
}
