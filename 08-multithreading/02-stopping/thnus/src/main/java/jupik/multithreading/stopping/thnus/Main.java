package jupik.multithreading.stopping.thnus;

public class Main
{
    static class Nupter implements Runnable
    {
        int curr;
        int last;

        Nupter(int first, int last)
        {
            this.curr = first;
            this.last = last;
        }

        @Override
        public void run()
        {
            try {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }

                for (; curr < last; ++curr)
                {
                    System.out.format("%d ", curr);
                    Thread.sleep(50);
                }
            }
            catch (InterruptedException e)
            {
                System.out.printf("<interrupted>");
            }
            finally
            {
                System.out.printf("\n");
            }
        }
    }

    public static void main(String []argv)
    {
        Nupter pt = new Nupter(0, 1000);
        Thread th = new Thread(pt);

        System.out.printf("Start.\n");
        th.start();

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
        }

        System.out.printf("<interrupt> ");
        th.interrupt();

        try
        {
            th.join();
        }
        catch (InterruptedException e)
        {
        }

        System.out.printf("Stop at %d\n", pt.curr);
    }
}
