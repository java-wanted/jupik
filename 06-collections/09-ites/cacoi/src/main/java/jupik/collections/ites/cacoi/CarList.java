package jupik.collections.ites.cacoi;

import java.util.Iterator;
import jupik.collections.arlis.capar.Car;

public interface CarList
    extends jupik.collections.cols.cacol.CarList, Iterable<Car>
{
    public boolean add(Car car);
    public boolean add(Car car, int index);
    public void clear();
    public boolean contains(Car car);
    public Car get(int index);
    public Iterator<Car> iterator();
    public boolean remove(Car car);
    public boolean removeAt(int index);
    public int size();
}
