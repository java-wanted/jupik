package jupik.multithreading.service.thsar;

import java.time.InstantSource;
import jupik.multithreading.stopping.thcar.Formula;

public class Main
{
    static class Sepr implements Runnable
    {
        int curr = 0;

        @Override
        public void run()
        {
            try
            {
                while (true)
                {
                    System.out.printf("%d ", curr++);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    static abstract class Calc implements Runnable
    {
        final InstantSource clock;
        final int id;
        final int n;

        Calc(InstantSource clock, int id, int n)
        {
            this.clock = clock;
            this.id = id;
            this.n = n;
        }

        abstract void calc(float []data) throws InterruptedException;

        @Override
        public void run()
        {
            float []data = new float[n];

            Formula.init(data, 1);

            long before = clock.millis();

            try
            {
                calc(data);
            }
            catch (InterruptedException e)
            {
                System.out.printf("\n%d: interrupted\n", id);
                System.exit(1);
            }

            long after = clock.millis();

            System.out.printf(
                "\n%d: milliseconds elapsed %d\n", id, after - before
            );
        }
    }

    public static void main(String []argv)
    {
        int n = 10_000_000;

        InstantSource clock = InstantSource.system();
        Thread sepr = new Thread(new Sepr());
        sepr.setDaemon(true);
        sepr.start();
        int id = 0;

        Thread []th = {
            new Thread(new Calc(clock, id++, n){
                void calc(float []data) throws InterruptedException
                {
                    Formula.calc(data);
                }
            }),
            new Thread(new Calc(clock, id++, n){
                void calc(float []data) throws InterruptedException
                {
                    Formula.calc2(data);
                }
            }),
        };

        th[0].start();
        th[1].start();
    }
}
