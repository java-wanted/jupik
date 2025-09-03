package jupik.multithreading.stopping.thcar;

import java.time.InstantSource;

public class Main
{
    static void init(float []data, float value)
    {
        for (int i = 0; i < data.length; ++i)
        {
            data[i] = value;
        }
    }

    static boolean _calc(float[] data, int i)
    {
        int l = 0x100;
        int j = 0;

        while (j < data.length)
        {
            if (Thread.interrupted())
            {
                return false;
            }

            for (int k = 0; k < l && j < data.length; ++k, ++j, ++i)
            {
                data[j] = (float)(data[j] * Math.sin(0.2f + i / 5f + i / 5f) *
                    Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
            }
        }

        return true;
    }

    static void calc(float []data) throws InterruptedException
    {
        if (!_calc(data, 0))
        {
            throw new InterruptedException();
        }
    }

    static class Runner implements Runnable
    {
        static class Status
        {
            boolean interrupted = false;
        }

        Status status;
        float []data;
        int i;

        Runner(Status status, float []data, int i)
        {
            this.status = status;
            this.data = data;
            this.i = i;
        }

        @Override
        public void run()
        {
            boolean intr = !_calc(data, i);

            synchronized (status)
            {
                status.interrupted |= intr;
            }
        }
    }

    static void calc2(float []data) throws InterruptedException
    {
        int n = data.length;
        int h = data.length / 2;
        float []d1 = new float[n - h];
        float []d2 = new float[h];

        System.arraycopy(data, 0, d1, 0, n - h);
        System.arraycopy(data, n - h, d2, 0, h);

        Runner.Status s = new Runner.Status();
        Thread []th = {
            new Thread(new Runner(s, d1, 0)),
            new Thread(new Runner(s, d2, n - h)),
        };
        boolean intr = false;

        th[0].start();
        th[1].start();

        try
        {
            th[0].join();
            th[1].join();
        }
        catch (InterruptedException e)
        {
            intr = true;

            th[0].interrupt();
            th[1].interrupt();

            try
            {
                th[0].join();
                th[1].join();
            }
            catch (InterruptedException g)
            {
            }
        }

        if (intr || s.interrupted)
        {
            throw new InterruptedException();
        }

        System.arraycopy(d1, 0, data, 0, n - h);
        System.arraycopy(d2, 0, data, n - h, h);
    }

    public static void main(String []argv)
    {
        int n = 10_000_000;
        float []data = new float[n];

        init(data, 1);

        InstantSource clock = InstantSource.system();
        long before = clock.millis();

        try
        {
            calc(data);
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        long after = clock.millis();

        System.out.printf("Milliseconds elapsed %d\n", after - before);

        float []data2 = new float[n];

        init(data2, 1);

        before = clock.millis();

        try
        {
            calc2(data2);
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        after = clock.millis();

        System.out.printf("Milliseconds elapsed %d\n", after - before);
    }
}
