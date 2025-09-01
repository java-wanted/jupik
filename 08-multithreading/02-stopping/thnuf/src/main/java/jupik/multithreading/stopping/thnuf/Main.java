package jupik.multithreading.stopping.thnuf;

import java.util.Collection;
import java.util.ArrayList;

public class Main
{
    static class Nufil implements Runnable
    {
        Collection<Integer> nums;
        int curr;
        int last;

        Nufil(Collection<Integer> nums, int first, int last)
        {
            if (nums == null)
            {
                throw new NullPointerException();
            }

            this.nums = nums;
            this.curr = first;
            this.last = last;
        }

        @Override
        public void run()
        {
            nums.clear();

            for (; curr < last; ++curr)
            {
                if (Thread.interrupted()) {
                    break;
                }

                nums.add(curr);
            }
        }
    }

    public static void main(String []argv)
    {
        int m = 3;
        int n = 1000000;

        ArrayList<ArrayList<Integer>> nums = new ArrayList<>(m);
        Thread []th = new Thread[m];

        for (int i = 0; i < th.length; ++i)
        {
            nums.add(new ArrayList<>(n));
            th[i] = new Thread(new Nufil(nums.get(i), 0, n));
        }

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
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        for (int i = 0; i < th.length; ++i) {
            int k = nums.get(i).size();

            if (k == n) {
                System.out.printf("%d: size %d\n", i, k);
            } else {
                System.out.printf("%d: size %d, but %d expected\n", i, k, n);
            }
        }
    }
}
