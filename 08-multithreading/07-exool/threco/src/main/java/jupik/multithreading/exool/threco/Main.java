package jupik.multithreading.exool.threco;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{
    static abstract class Computation implements Runnable
    {
        protected String id;
        protected boolean completed;
        protected long result;

        Computation(String id)
        {
            this.id = id;
            this.reset();
        }

        void reset()
        {
            completed = false;
        }

        String id()
        {
            return id;
        }

        boolean completed()
        {
            return completed;
        }

        long result()
        {
            if (!completed)
            {
                throw new NullPointerException();
            }

            return result;
        }

        abstract long compute() throws InterruptedException;

        public void run()
        {
            try
            {
                result = compute();
                completed = true;
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    static class Countable implements Runnable
    {
        CountDownLatch latch;
        Runnable job;

        Countable(CountDownLatch latch, Runnable job)
        {
            if (latch == null || job == null)
            {
                throw new NullPointerException();
            }

            this.latch = latch;
            this.job = job;
        }

        public void run()
        {
            try
            {
                job.run();
            }
            finally
            {
                latch.countDown();
            }
        }
    }

    static boolean execute(int posiz, Computation []jobs)
    {
        ExecutorService pool = Executors.newFixedThreadPool(posiz);
        CountDownLatch latch = new CountDownLatch(jobs.length);

        for (Computation j: jobs)
        {
            j.reset();
            pool.execute(new Countable(latch, j));
        }

        pool.shutdown();

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            pool.shutdownNow();
            boolean down = false;

            try
            {
                down = pool.awaitTermination(200, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException g)
            {
            }

            if (!down) {
                System.err.printf("Failed to interrupt\n");
                System.exit(1);
            }
        }

        for (Computation j: jobs)
        {
            if (!j.completed())
            {
                return false;
            }
        }

        return true;
    }

    static void compute(int posiz, Computation ...jobs)
    {
        System.out.printf(
            "Start %d jobs on %d tasks...\n", jobs.length, posiz
        );

        long before = System.currentTimeMillis();
        boolean done = execute(posiz, jobs);
        long after = System.currentTimeMillis();

        if (!done)
        {
            System.out.printf("Interrupted\n");
        }
        else
        {
            System.out.printf(
                "Completed in %d milliseconds:\n", after - before
            );

            for (Computation j: jobs)
            {
                System.out.printf("%s: %d\n", j.id(), j.result());
            }
        }
    }

    public static void main(String []argv)
    {
        Computation []jobs = {
            new Computation("1"){
                public long compute() throws InterruptedException
                {
                    return 1;
                }
            },
            new Computation("2"){
                public long compute() throws InterruptedException
                {
                    return 2;
                }
            },
            new Computation("3"){
                public long compute() throws InterruptedException
                {
                    return 3;
                }
            },
        };

        compute(3, jobs);
        compute(1, jobs);
    }
}
