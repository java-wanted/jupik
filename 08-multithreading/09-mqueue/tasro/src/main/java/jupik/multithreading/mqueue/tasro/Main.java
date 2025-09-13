package jupik.multithreading.mqueue.tasro;

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
    static class Printer implements Sjob<Object>
    {
        char letter;
        int count;

        Printer(char letter, int count)
        {
            if (count < 0)
            {
                throw new IllegalArgumentException();
            }

            this.letter = letter;
            this.count = count;
        }

        @Override
        public boolean hasStep()
        {
            return count > 0;
        }

        @Override
        public void step() throws Exception
        {
            if (count <= 0)
            {
                throw new RuntimeException();
            }

            --count;
            Thread.sleep(250);
            System.out.printf("%c", letter);
        }

        @Override
        public Object result()
        {
            if (count > 0)
            {
                throw new RuntimeException();
            }

            return null;
        }
    }

    public static void main(String []argv)
    {
        List<Rjob<Object>> jobs = List.of(
            new Rjob<>(new Printer('A', 5)),
            new Rjob<>(new Printer('B', 5)),
            new Rjob<>(new Printer('C', 5))
        );
        int jobn = jobs.size();

        for (int i = 0; i < jobn; ++i)
        {
            jobs.get(i).setPrev(jobs.get((jobn + i - 1) % jobn));
        }

        ExecutorService pool = Executors.newFixedThreadPool(jobn);
        List<Future<Object>> comp = new ArrayList<Future<Object>>(jobn);
        boolean interrupted = false;
        boolean stopped = false;

        for (int i = 0; i < jobn; ++i)
        {
            comp.add(pool.submit(jobs.get(i)));
        }

        pool.shutdown();

        System.out.printf("Start\n");
        jobs.get(jobn - 1).signal();

        try
        {
            for (int i = 0; i < jobn; ++i)
            {
                comp.get(i).get();
            }
        }
        catch (ExecutionException | InterruptedException e)
        {
            interrupted = true;
        }

        pool.shutdownNow();

        try
        {
            stopped = pool.awaitTermination(200, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
        }

        System.out.printf("\n");

        if (interrupted)
        {
            System.out.printf("Interrupted\n");
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
