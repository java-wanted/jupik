package jupik.collections.hamap.camap;

import java.util.List;
import java.util.Set;

import jupik.collections.arlis.capar.Car;

public interface CarMap
{
    public void clear();
    public Car get(CarOwner owner);
    public Set<CarOwner> keys();
    public void put(CarOwner owner, Car car);
    public boolean remove(CarOwner owner);
    public int size();
    public List<Car> values();
}
