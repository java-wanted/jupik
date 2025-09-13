package jupik.multithreading.mqueue.emque;

import java.util.LinkedList;
import jupik.multithreading.mqueue.exque.Mqueue;

public class Moqueue<E> implements Mqueue<E>
{
    protected LinkedList<E> data;

    public Moqueue()
    {
        this.data = new LinkedList<>();
    }

    @Override
    public void add(E e)
    {
        synchronized (this)
        {
            data.addLast(e);
            this.notify();
        }
    }

    @Override
    public E remove() throws InterruptedException
    {
        synchronized (this)
        {
            while (data.size() == 0)
            {
                this.wait();
            }

            return data.removeFirst();
        }
    }
}
