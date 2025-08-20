package jupik.multithreading.intro.thnum;

import java.util.stream.IntStream;

public class Main
{
    static class Nupter implements Runnable
    {
        int first;
        int last;

        Nupter(int first, int last)
        {
            this.first = first;
            this.last = last;
        }

        @Override
        public void run()
        {
            IntStream.range(first, last).forEachOrdered(
                v -> {
                    System.out.format("%d ", v);

                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
            );
            System.out.printf("\n");
        }
    }

    public static void main(String []argv)
    {
        Thread th = new Thread(new Nupter(0, 1000));

        System.out.printf("Start.\n");
        th.start();

        try
        {
            th.join();
        }
        catch (InterruptedException e)
        {
        }

        System.out.printf("Stop.\n");
    }
}
