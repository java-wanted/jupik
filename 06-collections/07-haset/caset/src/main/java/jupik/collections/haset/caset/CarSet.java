package jupik.collections.haset.caset;

import jupik.collections.arlis.capar.Car;

public interface CarSet
{
    public boolean add(Car car);
    public boolean remove(Car car);
    public int size();
    public void clear();
}
