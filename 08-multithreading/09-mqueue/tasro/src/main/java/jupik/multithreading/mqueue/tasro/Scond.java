package jupik.multithreading.mqueue.tasro;

class Scond implements Cond
{
    protected boolean interrupted = false;
    protected boolean ready = false;

    @Override
    public void await() throws InterruptedException
    {
        synchronized (this)
        {
            try
            {
                while (true)
                {
                    if (interrupted)
                    {
                        throw new InterruptedException();
                    }

                    if (ready)
                    {
                        ready = false;
                        break;
                    }

                    wait();
                }
            }
            catch (Exception e)
            {
                interrupted = true;
                throw e;
            }
        }
    }

    @Override
    public void signal()
    {
        synchronized (this)
        {
            ready = true;
            notify();
        }
    }

    @Override
    public void interrupt()
    {
        synchronized (this)
        {
            interrupted = true;
            notifyAll();
        }
    }
}
