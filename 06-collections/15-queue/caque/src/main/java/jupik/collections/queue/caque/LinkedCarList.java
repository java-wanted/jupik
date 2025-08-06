package jupik.collections.queue.caque;

import jupik.collections.arlis.capar.Car;

public class LinkedCarList
    extends jupik.collections.ites.cacoi.LinkedCarList
    implements CarQueue
{
    public LinkedCarList()
    {
    }

    @Override
    public boolean add(Car car)
    {
        return super.add(car);
    }

    @Override
    public Car peek()
    {
        return size() > 0 ? get(0) : null;
    }

    @Override
    public Car poll()
    {
        Car car = get(0);

        removeAt(0);

        return car;
    }
}
