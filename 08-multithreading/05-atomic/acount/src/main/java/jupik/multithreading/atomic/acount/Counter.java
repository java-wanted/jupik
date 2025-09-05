package jupik.multithreading.atomic.acount;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter
{
    protected AtomicInteger count = new AtomicInteger();

    public int count()
    {
        return count.get();
    }

    public void inc()
    {
        count.getAndIncrement();
    }

    public void dec()
    {
        count.getAndDecrement();
    }
}
