package jupik.collections.queue.caque;

import jupik.collections.arlis.capar.Car;
import jupik.collections.ites.cacoi.CarCollection;

public interface CarQueue extends CarCollection
{
    public boolean add(Car car);
    public Car peek();
    public Car poll();
}
