package jupik.multithreading.mqueue.tasro;

public interface Sjob<T>
{
    public boolean hasStep();
    public void step() throws Exception;
    public T result();
}
