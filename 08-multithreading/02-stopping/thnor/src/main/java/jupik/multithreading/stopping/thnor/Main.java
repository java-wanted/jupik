package jupik.multithreading.stopping.thnor;

public class Main
{
    static class Nupter implements Runnable
    {
        int idx;
        Thread prev;

        Nupter(int idx, Thread prev)
        {
            this.idx = idx;
            this.prev = prev;
        }

        @Override
        public void run()
        {
            boolean intr = false;

            try
            {
                if (prev == null)
                {
                    intr = Thread.interrupted();
                }
                else
                {
                    prev.join();
                }
            }
            catch (InterruptedException e)
            {
                intr = true;
            }

            if (intr)
            {
                System.out.printf("<interrupted>");
            }
            else
            {
                System.out.printf("%d ", idx);
            }
        }
    }

    public static void main(String []argv)
    {
        Thread []th = new Thread[3];
        Thread pr = null;

        for (int i = 0; i < th.length; ++i)
        {
            th[i] = new Thread(new Nupter(i + 1, pr));
            pr = th[i];
        }

        System.out.printf("Start\n");

        for (int i = 0; i < th.length; ++i)
        {
            th[i].start();
        }

        try
        {
            for (int i = 0; i < th.length; ++i)
            {
                th[i].join();
            }
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted");
            System.exit(1);
        }

        System.out.printf("\nStop\n");
    }
}
