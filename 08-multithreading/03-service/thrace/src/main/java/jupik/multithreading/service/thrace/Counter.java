package jupik.multithreading.service.thrace;

public class Counter
{
    protected int count = 0;

    public int count()
    {
        return count;
    }

    public void inc()
    {
        ++count;
    }

    public void dec()
    {
        --count;
    }
}
