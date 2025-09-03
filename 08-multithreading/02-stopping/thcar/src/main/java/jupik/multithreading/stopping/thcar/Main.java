package jupik.multithreading.stopping.thcar;

import java.time.InstantSource;

public class Main
{
    public static void main(String []argv)
    {
        int n = 10_000_000;
        float []data = new float[n];

        Formula.init(data, 1);

        InstantSource clock = InstantSource.system();
        long before = clock.millis();

        try
        {
            Formula.calc(data);
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        long after = clock.millis();

        System.out.printf("Milliseconds elapsed %d\n", after - before);

        float []data2 = new float[n];

        Formula.init(data2, 1);

        before = clock.millis();

        try
        {
            Formula.calc2(data2);
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
