package jupik.collections.ites.cacoi;

import java.util.Iterator;
import jupik.collections.arlis.capar.Car;

public interface CarSet
    extends CarCollection, jupik.collections.cols.cacol.CarSet
{
    public boolean add(Car car);
    public void clear();
    public boolean contains(Car car);
    public Iterator<Car> iterator();
    public boolean remove(Car car);
    public int size();
}
