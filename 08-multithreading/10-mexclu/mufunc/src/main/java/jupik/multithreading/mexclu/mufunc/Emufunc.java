package jupik.multithreading.mexclu.mufunc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Emufunc implements Mufunc
{
    protected static class Job implements Mufunc.Job
    {
        int id;
        int pages;
        boolean interrupted;
        boolean completed;

        public Job(int id, int pages)
        {
            this.id = id;
            this.pages = pages;
            this.interrupted = false;
            this.completed = false;
        }

        public synchronized void complete()
        {
            completed = true;
            notify();
        }

        public synchronized void interrupt()
        {
            interrupted = true;
            notify();
        }

        @Override
        public synchronized void await() throws InterruptedException
        {
            while (true)
            {
                if (interrupted)
                {
                    throw new InterruptedException();
                }

                if (completed)
                {
                    break;
                }

                wait();
            }
        }
    }

    protected static abstract class Func implements Runnable
    {
        public LinkedBlockingQueue<Job> queue;
        public AtomicInteger jobId;
        public boolean stopped;
        public Thread task;

        public Func(AtomicInteger jobId)
        {
            this.queue = new LinkedBlockingQueue<>();
            this.jobId = jobId;
            this.stopped = false;
        }

        public void run()
        {
            synchronized (this)
            {
                if (stopped)
                {
                    return;
                }

                task = Thread.currentThread();
            }

            try {
                while (true)
                {
                    Job j = queue.take();

                    try {
                        func(j);
                        j.complete();
                    }
                    catch (InterruptedException g)
                    {
                        j.interrupt();
                        throw g;
                    }
                }
            }
            catch (InterruptedException e)
            {
                synchronized (this)
                {
                    stopped = true;
                    queue.forEach((j) -> j.interrupt());
                }
            }
        }

        public synchronized Job queue(int pages)
            throws InterruptedException
        {
            if (stopped)
            {
                throw new InterruptedException();
            }

            Job job = new Job(jobId.getAndIncrement(), pages);

            queue.put(job);

            return job;
        }

        public synchronized void poweroff()
        {
            stopped = true;

            if (task == null)
            {
                queue.forEach((j) -> j.interrupt());
            }
            else
            {
                task.interrupt();
            }
        }

        public abstract void func(Job job) throws InterruptedException;
    }

    protected static class Punc extends Func
    {
        public Punc(AtomicInteger jobId)
        {
            super(jobId);
        }

        public void func(Job job) throws InterruptedException
        {
            for (int i = 0; i < job.pages; ++i)
            {
                Thread.sleep(500);
                System.out.printf(
                    "Job #%d: printed page %d of %d\n",
                    job.id, i + 1, job.pages
                );
            }
        }
    }

    protected static class Sunc extends Func
    {
        public Sunc(AtomicInteger jobId)
        {
            super(jobId);
        }

        public void func(Job job) throws InterruptedException
        {
            for (int i = 0; i < job.pages; ++i)
            {
                Thread.sleep(500);
                System.out.printf(
                    "Job #%d: scanned page %d of %d\n",
                    job.id, i + 1, job.pages
                );
            }
        }
    }

    protected AtomicInteger jobId;
    protected ExecutorService pool;
    protected Punc punc;
    protected Sunc sunc;

    public Emufunc()
    {
        jobId = new AtomicInteger(0);
        punc = new Punc(jobId);
        sunc = new Sunc(jobId);
        pool = Executors.newFixedThreadPool(2);
        pool.execute(punc);
        pool.execute(sunc);
    }

    public Mufunc.Job print(int pages) throws InterruptedException
    {
        return punc.queue(pages);
    }

    public Mufunc.Job scan(int pages) throws InterruptedException
    {
        return sunc.queue(pages);
    }

    public void poweroff() throws InterruptedException
    {
        punc.poweroff();
        sunc.poweroff();
        pool.shutdownNow();

        if (!pool.awaitTermination(200, TimeUnit.MILLISECONDS))
        {
            throw new InterruptedException();
        }
    }
}
