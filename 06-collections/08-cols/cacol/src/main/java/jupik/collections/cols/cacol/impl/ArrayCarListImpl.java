package jupik.collections.cols.cacol.impl;

import jupik.collections.arlis.capar.Car;
import jupik.collections.arlit.capas.ArrayCarList;

public class ArrayCarListImpl extends ArrayCarList
{
    public boolean contains(Car car)
    {
        return indexOf(car) != -1;
    }
}
