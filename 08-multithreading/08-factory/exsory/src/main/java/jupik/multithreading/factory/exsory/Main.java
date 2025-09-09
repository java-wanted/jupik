package jupik.multithreading.factory.exsory;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{
    static class Emuloader<T> implements Callable<T>
    {
        T value;

        Emuloader(T value)
        {
            this.value = value;
        }

        public T call() throws Exception
        {
            Thread.sleep(5000);

            return value;
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
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> fname = pool.submit(new Emuloader<String>("Saarah"));
        Future<Integer> fage = pool.submit(new Emuloader<Integer>(90));

        pool.execute(new Pointer());

        String name = null;
        Integer age = null;
        boolean interrupted = false;

        try
        {
            name = fname.get();
            age = fage.get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            interrupted = false;
        }

        if (!interrupted)
        {
            System.out.printf("Name is %s, Age is %d", name, age);
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
