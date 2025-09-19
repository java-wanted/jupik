package jupik.multithreading.semarace.fisem;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    static class Vfs
    {
        static final int N = 2;
        static Semaphore sem = new Semaphore(N);

        static void access(int id) throws InterruptedException
        {
            String name = Thread.currentThread().getName();

            sem.acquire();

            try
            {
                System.out.printf("%s: #%d starts vfs access\n", name, id);
                Thread.sleep(500);
            }
            finally
            {
                sem.release();
                System.out.printf("%s: #%d completed vfs access\n", name, id);
            }
        }
    }

    static class Job implements Callable<Object>
    {
        int id;
        int tout_ms;

        Job(int id)
        {
            this.id = id;
            tout_ms = rand.nextInt(400, 800);
        }

        public Object call() throws Exception
        {
            String name = Thread.currentThread().getName();

            System.out.printf("%s: #%d started\n", name, id);
            Thread.sleep(tout_ms);
            Vfs.access(id);
            System.out.printf("%s: #%d completed\n", name, id);

            return null;
        }
    }

    static Random rand = new Random();

    public static void main(String []argv)
    {
        int njobs = 10;
        List<Job> jobs = new ArrayList<>(njobs);

        for (int i = 0; i < njobs; ++i)
        {
            jobs.add(new Job(i));
        }

        ExecutorService pool = Executors.newFixedThreadPool(njobs / 2);
        List<Future<Object>> comp = new ArrayList<>(njobs);
        boolean interrupted = false;
        boolean stopped = false;

        for (Job j: jobs)
        {
            comp.add(pool.submit(j));
        }

        try
        {
            for (Future<Object> c: comp)
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
            System.out.printf("Done\n");
        }
    }
}
