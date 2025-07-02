package jupik.collections.arlis.capar;

public interface CarList
{
    public Car get(int index);
    public void add(Car car);
    public boolean remove(Car car);
    public boolean removeAt(int index);
    public int size();
    public void clear();
}
