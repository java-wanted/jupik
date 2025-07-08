package jupik.collections.ites.cacoi;

import java.util.Objects;
import jupik.collections.arlis.capar.Car;

class ICar implements Car
{
    int index;

    ICar(int index)
    {
        this.index = index;
    }

    public String brand()
    {
        return String.format("%d", index);
    }

    public int number()
    {
        return index;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(index);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }
        else if (o == null)
        {
            return false;
        }
        else if (o instanceof ICar c)
        {
            return index == c.index;
        }
        else
        {
            return false;
        }
    }
}
