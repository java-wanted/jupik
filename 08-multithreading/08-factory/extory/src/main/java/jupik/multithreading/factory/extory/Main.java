package jupik.multithreading.factory.extory;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public class Main
{
    static class Extory implements ThreadFactory
    {
        @Override
        public Thread newThread(Runnable r)
        {
            Thread th = new Thread(r);

            th.setDaemon(true);

            return th;
        }
    }

    public static void main(String []argv)
    {
        Runnable job = new Runnable(){
            public void run()
            {
                try
                {
                    for (int i = 0; ; ++i)
                    {
                        System.out.printf("%d\n", i);
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e)
                {
                    System.out.printf("<interrupted>\n");
                }
            }
        };
        ExecutorService pool = Executors.newSingleThreadExecutor(new Extory());

        pool.execute(job);

        try
        {
            for (int i = 0; i < 10; ++i)
            {
                System.out.printf(".");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted\n");
        }

        System.out.printf("Done\n");
    }
}
