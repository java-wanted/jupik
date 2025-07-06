package jupik.collections.cols.cacol.impl;

import jupik.collections.arlis.capar.Car;
import jupik.collections.lilis.capal.LinkedCarList;

public class LinkedCarListImpl extends LinkedCarList
{
    public boolean contains(Car car)
    {
        return nodeOf(car) != null;
    }
}
