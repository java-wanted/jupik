package jupik.multithreading.sync.cashpo;

public class Runner
{
    protected Thread []th;

    public Runner(Runnable ...tasks)
    {
        th = new Thread[tasks.length];

        for (int i = 0; i < th.length; ++i)
        {
            th[i] = new Thread(tasks[i]);
        }
    }

    public void start()
    {
        for (int i = 0; i < th.length; ++i)
        {
            th[i].start();
        }
    }

    public void interrupt()
    {
        for (int i = 0; i < th.length; ++i)
        {
            th[i].interrupt();
        }
    }

    public void join() throws InterruptedException
    {
        try
        {
            for (int i = 0; i < th.length; ++i)
            {
                th[i].join();
            }
        }
        catch (InterruptedException e)
        {
            interrupt();

            try
            {
                for (int i = 0; i < th.length; ++i)
                {
                    th[i].join();
                }
            }
            catch (InterruptedException g)
            {
            }

            throw e;
        }
    }
}
