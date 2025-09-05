package jupik.multithreading.atomic.acount;

public class Main
{
    static abstract class OneCounter implements Runnable
    {
        static class State
        {
            volatile boolean interrupted = false;
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
            int i = 0;

            while (i < n)
            {
                if (state.interrupted || Thread.interrupted())
                {
                    state.interrupted = true;
                    break;
                }
                for (int j = 0; i < n && j < l; ++j, ++i)
                {
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
        Runner r = new Runner(
            new OneCounter(s, c, n){
                void count()
                {
                    counter.inc();
                }
            },
            new OneCounter(s, c, n){
                void count()
                {
                    counter.dec();
                }
            }
        );
        boolean intr = false;

        r.start();

        try
        {
            r.join();
            intr = s.interrupted;
        }
        catch (InterruptedException e)
        {
            intr = true;
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
