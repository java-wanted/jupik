package jupik.multithreading.mqueue.exque;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main
{
    public static void main(String []argv)
    {
        Mqueue<Runnable> exque = new Lqueue<Runnable>();
        Runner runner = new Runner(Executors.newFixedThreadPool(3), exque);
        Thread runth = new Thread(runner);
        Job []jobs = {
            new Job(1, 2000),
            new Job(2, 1000),
            new Job(3, 1500),
            new Job(4, 800),
            null,
        };

        runth.start();

        try
        {
            for (Job j: jobs)
            {
                exque.add(j);
            }

            runth.join();
        }
        catch (InterruptedException e)
        {
            runth.interrupt();

            try
            {
                runth.join(400);
            }
            catch (InterruptedException g)
            {
            }

            if (runth.isAlive())
            {
                System.out.printf("Failed to interrupt\n");
                System.exit(1);
            }
        }

        if (!runner.isCompleted())
        {
            System.out.printf("Interrupted\n");
        }
        else
        {
            System.out.printf("Done\n");
        }
    }
}
