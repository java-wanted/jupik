package jupik.collections.lilis.capal;

import jupik.collections.arlis.capar.Car;
import jupik.collections.arlit.capas.CarList;
import java.util.Arrays;

public class LinkedCarList implements CarList
{
    protected static class Node
    {
        public Node prev;
        public Node next;
        public Car car;

        protected Node(Car car)
        {
            this.car = car;
        }
    }

    protected Node head;
    protected Node tail;
    protected int size;

    protected void initialise()
    {
        for (Node node = head; node != null; node = node.next)
        {
            node.prev = null;
        }

        size = 0;
    }

    protected void validateIndex(int last, int index)
    {
        if (index < 0 || index >= last)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    protected Node nodeAt(int index)
    {
        Node node = head;

        for (; index-- > 0; node = node.next)
        {
        }

        return node;
    }

    protected Node nodeOf(Car car)
    {
        Node node = head;

        if (car == null) {
            for (; node != null && node.car != null; node = node.next)
            {
            }
        } else {
            for (; node != null && !node.car.equals(car); node = node.next)
            {
            }
        }

        return node;
    }

    protected boolean removeNode(Node node)
    {
        if (node.prev == null)
        {
            head = node.next;
        }
        else
        {
            node.prev.next = node.next;
        }

        if (node.next == null)
        {
            tail = node.prev;
        }
        else
        {
            node.next.prev = node.prev;
        }

        --size;

        return true;
    }

    public LinkedCarList()
    {
        initialise();
    }

    @Override
    public void add(Car car)
    {
        add(car, size);
    }

    @Override
    public void add(Car car, int index)
    {
        validateIndex(size + 1, index);
        Node node = new Node(car);

        if (tail == null)
        {
            tail = node;
            head = node;
        }
        else
        {
            Node next = nodeAt(index);

            if (next == null)
            {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            else if (next.prev == null)
            {
                node.next = next;
                next.prev = node;
                head = node;
            }
            else
            {
                node.prev = next.prev;
                node.next = next;
                next.prev.next = node;
                next.prev = node;
            }
        }

        ++size;
    }

    @Override
    public void clear()
    {
        initialise();
    }

    @Override
    public Car get(int index)
    {
        validateIndex(size, index);

        return nodeAt(index).car;
    }

    @Override
    public boolean removeAt(int index)
    {
        validateIndex(size, index);

        return removeNode(nodeAt(index));
    }

    @Override
    public boolean remove(Car car)
    {
        Node node = nodeOf(car);

        return node != null ? removeNode(node) : false;
    }

    @Override
    public int size()
    {
        return size;
    }
}
