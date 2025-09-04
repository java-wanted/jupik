package jupik.multithreading.sync.cashpo;

public class Request implements Runnable
{
    protected Cashpoint cash;
    protected String name;
    protected int amount;
    protected int result;

    public Request(Cashpoint cash, String name, int amount)
    {
        if (cash == null || name == null)
        {
            throw new NullPointerException();
        }

        if (amount < 0)
        {
            throw new IllegalArgumentException();
        }

        this.cash = cash;
        this.name = name;
        this.amount = amount;
        this.result = 0;
    }

    public String name()
    {
        return name;
    }

    public int amount()
    {
        return amount;
    }

    public int result()
    {
        return result;
    }

    @Override
    public void run()
    {
        try
        {
            result = cash.take(name, amount) ? amount : 0;

        }
        catch (InterruptedException e)
        {
        }
    }
}
