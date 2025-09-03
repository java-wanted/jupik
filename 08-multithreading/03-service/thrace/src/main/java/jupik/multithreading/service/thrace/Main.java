package jupik.multithreading.service.thrace;

public class Main
{
    public static void main(String []argv)
    {
        int n = 1000;
        Counter c = new Counter();

        for (int i = 0; i < n; ++i)
        {
            c.inc();
        }

        for (int i = 0; i < n; ++i)
        {
            c.dec();
        }

        if (c.count() != 0)
        {
            System.out.printf("Count is %d, but zero expected\n", c.count());
            System.exit(1);
        }
    }
}
