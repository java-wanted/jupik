package jupik.collections.cols.cacol.impl;

import jupik.collections.arlis.capar.Car;
import jupik.collections.haset.caset.HashCarSet;

public class HashCarSetImpl extends HashCarSet
{
    public boolean contains(Car car)
    {
        int idx = binIndex(bins, car);
        Pair pair = prevOf(bins[idx], car);

        return pair.node() != null;
    }
}
