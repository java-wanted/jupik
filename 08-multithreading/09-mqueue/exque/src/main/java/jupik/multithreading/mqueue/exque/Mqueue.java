package jupik.multithreading.mqueue.exque;

public interface Mqueue<E>
{
    public void add(E e);
    public E remove() throws InterruptedException;
}
