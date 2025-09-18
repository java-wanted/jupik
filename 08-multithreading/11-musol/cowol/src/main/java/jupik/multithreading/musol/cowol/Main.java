package jupik.multithreading.musol.cowol;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    static abstract class Job implements Callable<Job.Result>
    {
        public static record Result(long sum, long elapsed)
        {
        }

        List<Integer> list;
        int count;
        CountDownLatch ready = new CountDownLatch(1);
        CountDownLatch start = new CountDownLatch(1);

        Job(List<Integer> list, int count)
        {
            this.list = list;
            this.count = count;
        }

        public Result call() throws Exception
        {
            ready.countDown();
            start.await();

            long before = System.nanoTime();
            long sum = process(list, count);
            long after = System.nanoTime();

            return new Result(sum, after - before);
        }

        void awaitReady() throws InterruptedException
        {
            ready.await();
        }

        void start()
        {
            start.countDown();
        }

        abstract long process(List<Integer> list, int count)
            throws InterruptedException;
    }

    static class Wob extends Job
    {
        Wob(List<Integer> list, int count)
        {
            super(list, count);
        }

        long process(List<Integer> list, int count) throws InterruptedException
        {
            long sum = 0;

            for (int k = 0; k < count; ++k)
            {
                Thread.sleep(0, 1000);

                for (int i = 0; i < list.size(); ++i)
                {
                    sum += k + i;
                    list.set(i, k + i);
                }
            }

            return sum;
        }
     }

    static class Rob extends Job
    {
        Rob(List<Integer> list, int count)
        {
            super(list, count);
        }

        long process(List<Integer> list, int count) throws InterruptedException
        {
            int sum = 0;

            for (int k = 0; k < count; ++k)
            {
                Thread.sleep(0, 2000);

                for (int i = 0; i < list.size(); ++i)
                {
                    sum += list.get(i);
                }
            }

            return sum;
        }
    }

    static List<Job.Result> process(ExecutorService pool, List<Job> jobs)
        throws ExecutionException, InterruptedException
    {
        List<Future<Job.Result>> com = new ArrayList<>(jobs.size());
        List<Job.Result> res = new ArrayList<>(jobs.size());

        for (Job j: jobs)
        {
            com.add(pool.submit(j));
        }

        for (Job j: jobs)
        {
            j.awaitReady();
        }

        for (Job j: jobs)
        {
            j.start();
        }

        for (Future<Job.Result> c: com)
        {
            res.add(c.get());
        }

        return res;
    }

    static void report(String title, List<Job.Result> res)
    {
        System.out.printf("%s:\n", title);

        for (Job.Result r: res)
        {
            System.out.printf("  %d\t%d\n", r.elapsed(), r.sum());
        }
    }

    public static void main(String []argv)
    {
        final int lsiz = 10000;
        final int lcnt = 4;

        List<Integer> slist = Collections.synchronizedList(
            new ArrayList<>(lsiz));

        for (int i = 0; i < lsiz; ++i)
        {
            slist.add(0);
        }

        List<Job> sobs = List.of(
            new Wob(slist, lcnt),
            new Rob(slist, lcnt),
            new Wob(slist, lcnt),
            new Rob(slist, lcnt)
        );

        List<Integer> clist = new CopyOnWriteArrayList<>(slist);
        List<Job> cobs = List.of(
            new Wob(clist, lcnt),
            new Rob(clist, lcnt),
            new Wob(clist, lcnt),
            new Rob(clist, lcnt)
        );

        ExecutorService pool = Executors.newCachedThreadPool();
        List<Job.Result> sers = null;
        List<Job.Result> cers = null;
        boolean interrupted = false;
        boolean stopped = false;

        try
        {
            sers = process(pool, sobs);
            cers = process(pool, cobs);
        }
        catch (ExecutionException | InterruptedException e)
        {
            interrupted = true;
            System.out.printf("Interrupted\n");
        }

        pool.shutdownNow();

        try
        {
            stopped = pool.awaitTermination(200, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
        }

        if (!stopped)
        {
            System.err.printf("Failed to terminate\n");
            System.exit(1);
        }

        if (!interrupted)
        {
            report("synchronised", sers);
            report("copy-on-write", cers);

            System.out.printf("Done\n");
        }
    }
}
