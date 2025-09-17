package jupik.multithreading.mexclu.mufunc;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;

public class Main
{
    static abstract class Job implements Callable<Object>
    {
        Mufunc mufunc;
        int pages;

        Job(Mufunc mufunc, int pages)
        {
            this.mufunc = mufunc;
            this.pages = pages;
        }

        public Object call() throws Exception
        {
            process();

            return null;
        }

        protected abstract void process() throws InterruptedException;
    }

    static class Pjob extends Job
    {
        Pjob(Mufunc mufunc, int pages)
        {
            super(mufunc, pages);
        }

        protected void process() throws InterruptedException
        {
            mufunc.print(pages).await();
        }
    }

    static class Sjob extends Job
    {
        Sjob(Mufunc mufunc, int pages)
        {
            super(mufunc, pages);
        }

        protected void process() throws InterruptedException
        {
            mufunc.scan(pages).await();
        }
    }

    public static void main(String []argv)
    {
        Mufunc mufunc = new Emufunc();
        Job []jobs = {
            new Pjob(mufunc, 2),
            new Pjob(mufunc, 3),
            new Pjob(mufunc, 4),
            new Pjob(mufunc, 5),
            new Sjob(mufunc, 2),
            new Sjob(mufunc, 5),
        };

        ExecutorService pool = Executors.newFixedThreadPool(jobs.length);
        LinkedList<Future<Object>> coms = new LinkedList<>();
        boolean interrupted = false;
        boolean stopped = false;

        System.out.printf("Start\n");

        for (Job j: jobs)
        {
            coms.add(pool.submit(j));
        }

        pool.shutdown();

        try
        {
            for (Future<Object> c: coms)
            {
                c.get();
            }
        }
        catch (ExecutionException | InterruptedException e)
        {
            interrupted = true;
            System.out.printf("Interrupted\n");
        }

        pool.shutdownNow();

        try
        {
            mufunc.poweroff();
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
            System.out.printf("Done\n");
        }
    }
}
