package jupik.collections.cols.cacol;

import jupik.collections.arlis.capar.Car;

public interface CarList extends CarCollection
{
    public boolean add(Car car);
    public boolean add(Car car, int index);
    public void clear();
    public Car get(int index);
    public boolean remove(Car car);
    public boolean removeAt(int index);
    public int size();
}
