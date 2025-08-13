package jupik.generics.parops.agrar;

import jupik.generics.parms.pcols.LinkedList;
import jupik.generics.parms.pcols.List;

public class Basket<E extends Fruit> implements Comparable<Basket<? extends Fruit>>
{
    protected List<E> elems;
    protected float weight;

    public Basket()
    {
        elems = new LinkedList<>();
        weight = 0;
    }

    public void add(E e)
    {
        elems.add(e);
        weight += e.weight();
    }

    @Override
    public int compareTo(Basket<? extends Fruit> other)
    {
        return Float.compare(weight, other.weight);
    }

    public void transfer(Basket<? extends E> other)
    {
        if (other != null)
        {
            for (E e: other.elems)
            {
                add(e);
            }

            other.elems.clear();
            other.weight = 0;
        }
    }

    public float weight()
    {
        return weight;
    }
}
