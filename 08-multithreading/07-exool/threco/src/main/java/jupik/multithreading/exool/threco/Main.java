package jupik.multithreading.exool.threco;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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
        /* The three computation problem */
        Computation []jobs = {
            new Computation("1"){
                /* The sum of all even integers from 0 to 1 000 000 inclusive */
                public long compute() throws InterruptedException
                {
                    int n = 1_000_000 + 1;
                    int l = 0x100;
                    int i = 0;
                    long s = 0;

                    while (i < n)
                    {
                        if (Thread.interrupted())
                        {
                            throw new InterruptedException();
                        }

                        for (int k = 0; k < l && i < n; ++k, ++i)
                        {
                            if ((i & 1) == 0)
                            {
                                s += i;
                            }
                        }
                    }

                    return s;
                }
            },
            /* The sum of all integers from 0 to 1000000 inclusive, divided by 7
             * with a zero remainder
             */
            new Computation("2"){
                public long compute() throws InterruptedException
                {
                    int n = 1_000_000 + 1;
                    int l = 0x100;
                    int i = 0;
                    long s = 0;

                    while (i < n)
                    {
                        if (Thread.interrupted())
                        {
                            throw new InterruptedException();
                        }

                        for (int k = 0; k < l && i < n; ++k, ++i)
                        {
                            if (i % 7 == 0)
                            {
                                s += i;
                            }
                        }
                    }

                    return s;
                }
            },
            /* The number of even values in a collection of 1000 random
             * integers.
             */
            new Computation("3"){
                public long compute() throws InterruptedException
                {
                    int n = 1_000;
                    Collection<Integer> data = new ArrayList<>(n);
                    Random r = new Random();
                    int l = 0x100;
                    int i = 0;
                    long c = 0;

                    while (i < n)
                    {
                        if (Thread.interrupted())
                        {
                            throw new InterruptedException();
                        }

                        for (int k = 0; k < l && i < n; ++k, ++i)
                        {
                            data.add(r.nextInt());
                        }
                    }

                    i = 0;

                    while (i < n)
                    {
                        if (Thread.interrupted())
                        {
                            throw new InterruptedException();
                        }

                        for (int k = 0; k < l && i < n; ++k, ++i)
                        {
                            if ((i & 1) == 0)
                            {
                                ++c;
                            }
                        }
                    }

                    return c;
                }
            },
        };

        compute(3, jobs);
        compute(1, jobs);
    }
}
