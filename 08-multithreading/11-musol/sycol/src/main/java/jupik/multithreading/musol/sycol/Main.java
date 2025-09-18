package jupik.multithreading.musol.sycol;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Main
{
    static class Job implements Callable<Object>
    {
        List<Integer> list;
        int count;

        Job(List<Integer> list, int count)
        {
            this.list = list;
            this.count = count;
        }

        public Object call() throws Exception
        {
            for (int i = 0; i < count; ++i)
            {
                list.add(i);
            }

            return null;
        }
    }

    public static void main(String []argv)
    {
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> slist = Collections.synchronizedList(list);
        int n = 100;
        Job []jobs = {
            new Job(slist, n),
            new Job(slist, n),
        };
        ExecutorService pool = Executors.newFixedThreadPool(jobs.length);
        LinkedList<Future<Object>> coms = new LinkedList<>();
        boolean interrupted = false;
        boolean stopped = false;

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
            int r = list.size();
            int e = 0;

            for (Job j: jobs)
            {
                e += j.count;
            }

            if (r != e)
            {
                System.err.printf(
                    "There are %e numbers, but %d expected\n", r, e
                );
                System.exit(1);
            }

            System.out.printf("Done\n");
        }
    }
}
