package jupik.multithreading.mqueue.exque;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.LinkedList;

public class Lqueue<E> implements Mqueue<E>
{
    protected ReentrantLock lock;
    protected Condition empty;
    protected LinkedList<E> data;

    public Lqueue()
    {
        this.lock = new ReentrantLock();
        this.empty = this.lock.newCondition();
        this.data = new LinkedList<>();
    }

    @Override
    public void add(E e)
    {
        this.lock.lock();

        try
        {
            data.addLast(e);
            empty.signal();
        }
        finally
        {
            this.lock.unlock();
        }
    }

    @Override
    public E remove() throws InterruptedException
    {
        this.lock.lock();

        try
        {
            while (data.size() == 0)
            {
                this.empty.await();
            }

            return data.removeFirst();
        }
        finally
        {
            this.lock.unlock();
        }
    }
}
