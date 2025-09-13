package jupik.multithreading.mqueue.tasro;

public interface Cond
{
    public void await() throws InterruptedException;
    public void signal();
    public void interrupt();
}
