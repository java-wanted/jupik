package jupik.multithreading.sync.cashmo;

import jupik.multithreading.sync.cashpo.Cashpoint;

public class Multipoint implements Cashpoint
{
    public final int TOUT_MS = 2000;

    protected Integer total;
    protected Object sync;

    public Multipoint(int total)
    {
        this.total = total;
        this.sync = new Object();
    }

    public int total()
    {
        return total;
    }

    public boolean take(String name, int amount) throws InterruptedException
    {
        System.out.printf("%s has come to the cashpoint\n", name);

        Thread.sleep(TOUT_MS);

        int drawn = 0;

        synchronized (sync)
        {
            if (amount <= total)
            {
                total -= amount;
                drawn = amount;
            }
        }

        if (drawn != amount)
        {
            System.out.printf("There is no enough money for %s\n", name);
            return false;
        }
        else
        {
            System.out.printf("%s has withdrawn %d rubles\n", name, amount);
            return true;
        }
    }
}
