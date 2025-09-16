package jupik.multithreading.mexclu.traval;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    static class Values
    {
        Object []locks;
        Integer []values;

        Values(int first, int second)
        {
            locks = List.of(new Object(), new Object()).toArray(new Object[0]);
            values = List.of(first, second).toArray(new Integer[0]);
        }

        boolean transfer(int i, int j, int value) throws InterruptedException
        {
            synchronized (locks[0])
            {
                synchronized (locks[i])
                {
                    Thread.sleep(1000);

                    if (value > values[i])
                    {
                        return false;
                    }
                    else
                    {
                        System.out.printf(
                            "Transfer of %d to %d accepted\n", i, j
                        );

                        Thread.sleep(1000);

                        synchronized (locks[j])
                        {
                            values[i] -= value;
                            values[j] += value;
                        }

                        return true;
                    }
                }
            }
        }

        boolean transferFirstToSecond(int value) throws InterruptedException
        {
            return transfer(1, 0, value);
        }

        boolean transferSecondToFirst(int value) throws InterruptedException
        {
            return transfer(1, 0, value);
        }
    }

    public static void main(String []argv)
    {
        Values values = new Values(1000, 1000);
        List<Callable<Boolean>> jobs = List.of(
            new Callable<>(){
                public Boolean call() throws Exception
                {
                    return values.transferFirstToSecond(100);
                }
            },
            new Callable<>(){
                public Boolean call() throws Exception
                {
                    return values.transferSecondToFirst(100);
                }
            }
        );

        ExecutorService pool = Executors.newFixedThreadPool(2);
        List<Future<Boolean>> comp = new ArrayList<>(2);
        boolean interrupted = false;
        boolean stopped = false;

        System.out.printf("Start\n");

        for (int i = 0; i < jobs.size(); ++i)
        {
            comp.add(pool.submit(jobs.get(i)));
        }

        pool.shutdown();

        try
        {
            for (int i = 0; i < jobs.size(); ++i)
            {
                boolean res = comp.get(i).get();

                System.out.printf(
                    "Transfer #%d %s\n", i, res ? "completed" : "rejected"
                );
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
            System.out.printf("Done\n");
        }
    }
}
