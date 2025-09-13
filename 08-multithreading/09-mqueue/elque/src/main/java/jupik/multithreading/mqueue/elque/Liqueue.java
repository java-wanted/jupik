package jupik.multithreading.mqueue.elque;

import java.util.concurrent.LinkedBlockingQueue;
import jupik.multithreading.mqueue.exque.Mqueue;

public class Liqueue<E> implements Mqueue<E>
{
    protected static class Elem<E>
    {
        public E e;

        public Elem(E e)
        {
            this.e = e;
        }
    }

    LinkedBlockingQueue<Elem<E>> data;

    public Liqueue()
    {
        data = new LinkedBlockingQueue<>();
    }

    @Override
    public void add(E e)
    {
        try
        {
            data.put(new Elem<E>(e));
        }
        catch (InterruptedException g)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public E remove() throws InterruptedException
    {
        return data.take().e;
    }
}
