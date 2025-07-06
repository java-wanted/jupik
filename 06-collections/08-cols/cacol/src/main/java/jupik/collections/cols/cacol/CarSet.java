package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

public interface CarSet extends CarCollection
{
    public boolean add(Car car);
    public void clear();
    public boolean contains(Car car);
    public boolean remove(Car car);
    public int size();
}
