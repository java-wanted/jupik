package jupik.multithreading.mqueue.exque;

public class Job implements Runnable
{
    protected int id;
    protected int ms;

    public Job(int id, int ms)
    {
        this.id = id;
        this.ms = ms;
    }

    public void run()
    {
        System.out.printf("%d started\n", id);

        try
        {
            Thread.sleep(ms);
            System.out.printf("%d done\n", id);
        }
        catch (InterruptedException e)
        {
            System.out.printf("%d interrupted\n", id);
        }
    }
}
