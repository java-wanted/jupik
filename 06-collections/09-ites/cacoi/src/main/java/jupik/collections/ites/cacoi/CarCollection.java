package jupik.collections.ites.cacoi;

import java.util.Iterator;
import jupik.collections.arlis.capar.Car;

public interface CarCollection
    extends jupik.collections.cols.cacol.CarCollection, Iterable<Car>
{
    public boolean add(Car car);
    public void clear();
    public Iterator<Car> iterator();
    public boolean remove(Car car);
    public int size();
}
