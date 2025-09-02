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

    static void _calc(float[] data, int i)
    {
        for (int j = 0; j < data.length; ++j, ++i)
        {
            data[j] = (float)(data[j] * Math.sin(0.2f + i / 5f + i / 5f) *
                Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
    }

    static void calc(float []data)
    {
        _calc(data, 0);
    }

    static void calc2(float []data) throws InterruptedException
    {
        int n = data.length;
        int h = data.length / 2;
        float []d1 = new float[n - h];
        float []d2 = new float[h];

        System.arraycopy(data, 0, d1, 0, n - h);
        System.arraycopy(data, n - h, d2, 0, h);

        Thread []th = {
            new Thread(() -> { _calc(d1, 0); }),
            new Thread(() -> { _calc(d2, n - h); }),
        };

        th[0].start();
        th[1].start();

        th[0].join();
        th[1].join();

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

        calc(data);

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
