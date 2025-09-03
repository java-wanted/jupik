package jupik.multithreading.service.thrace;

public class Main
{
    static abstract class OneCounter implements Runnable
    {
        static class State
        {
            boolean interrupted = false;
        }

        State state;
        Counter counter;
        int n;

        OneCounter(State state, Counter counter, int n)
        {
            this.state = state;
            this.counter = counter;
            this.n = n;
        }

        abstract void count();

        @Override
        public void run()
        {
            int l = 0x100;

            for (int i = 0; i < n; ++i)
            {
                synchronized (counter)
                {
                    if (state.interrupted || Thread.interrupted())
                    {
                        state.interrupted = true;
                        break;
                    }

                    count();
                }
            }
        }
    }

    public static void main(String []argv)
    {
        int n = 1000;
        Counter c = new Counter();
        OneCounter.State s = new OneCounter.State();
        Thread []th = {
            new Thread(new OneCounter(s, c, n){
                void count()
                {
                    counter.inc();
                }
            }),
            new Thread(new OneCounter(s, c, n){
                void count()
                {
                    counter.dec();
                }
            }),
        };
        boolean intr = false;

        th[0].start();
        th[1].start();

        try
        {
            th[0].join();
            th[1].join();
            intr = s.interrupted;
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

        if (intr)
        {
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        if (c.count() != 0)
        {
            System.out.printf("Count is %d, but zero expected\n", c.count());
            System.exit(1);
        }
    }
}
