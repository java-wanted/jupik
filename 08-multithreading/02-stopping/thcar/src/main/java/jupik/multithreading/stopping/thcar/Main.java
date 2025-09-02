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

    static void calc(float[] data)
    {
        for (int i = 0; i < data.length; ++i)
        {
            data[i] = (float)(data[i] * Math.sin(0.2f + i / 5f + i / 5f) *
                Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
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
    }
}
