package jupik.multithreading.sync.cashpo;

public class Joinpoint implements Cashpoint
{
    protected class Join
    {
        Thread curr = null;

        public void acquire() throws InterruptedException
        {
            while (true)
            {
                Thread prev = null;

                synchronized (this)
                {
                    if (curr == null)
                    {
                        curr = Thread.currentThread();
                        break;
                    }

                    prev = curr;
                }

                prev.join();
            }
        }

        public void release()
        {
            synchronized (this)
            {
                if (curr == Thread.currentThread())
                {
                    curr = null;
                }
            }
        }
    }

    public final int TOUT_MS = 2000;

    protected int total;
    protected Join join;

    public Joinpoint(int total)
    {
        this.total = total;
        this.join = new Join();
    }

    public int total()
    {
        return total;
    }

    public boolean take(String name, int amount) throws InterruptedException
    {
        System.out.printf("%s has come to the cashpoint\n", name);

        try
        {
            join.acquire();
            Thread.sleep(TOUT_MS);

            if (amount > total)
            {
                System.out.printf("There is no enough money for %s\n", name);
                return false;
            }
            else
            {
                total -= amount;
                System.out.printf("%s has withdrawn %d rubles\n", name, amount);
                return true;
            }
        }
        finally
        {
            join.release();
        }
    }
}
