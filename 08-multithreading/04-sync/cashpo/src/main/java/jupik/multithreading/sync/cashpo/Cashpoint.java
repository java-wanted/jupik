package jupik.multithreading.sync.cashpo;

public interface Cashpoint
{
    public int total();
    public boolean take(String name, int amount) throws InterruptedException;
}
