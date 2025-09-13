package jupik.multithreading.mqueue.tasro;

import java.util.concurrent.Callable;

public class Rjob<T> implements Callable<T>, Cond
{
    protected Cond cond;
    protected Cond prev;
    protected Sjob<T> job;

    public Rjob(Sjob<T> job)
    {
        this.cond = new Scond();
        this.job = job;
    }

    public void setPrev(Cond prev)
    {
        this.prev = prev;
    }

    @Override
    public void await() throws InterruptedException
    {
        cond.await();
    }

    @Override
    public void signal()
    {
        cond.signal();
    }

    @Override
    public void interrupt()
    {
        cond.interrupt();
    }

    @Override
    public T call() throws Exception
    {
        try {
            if (prev == null)
            {
                throw new RuntimeException();
            }

            while (job.hasStep())
            {
                prev.await();
                job.step();
                cond.signal();
            }

            return job.result();
        }
        catch (Exception e)
        {
            cond.interrupt();
            throw e;
        }
    }
}
