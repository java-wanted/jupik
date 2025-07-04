package jupik.collections.equas.hacom;

import java.util.Objects;
import jupik.collections.arlis.capar.Car;

public class CarA implements Car
{
    protected int number;
    protected String brand;

    public CarA(int number, String brand)
    {
        this.number = number;
        this.brand = brand;
    }

    @Override
    public int number()
    {
        return number;
    }

    @Override
    public String brand()
    {
        return brand;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null)
        {
            return false;
        }
        else if (obj instanceof CarA o)
        {
            return number == o.number && Objects.equals(brand, o.brand);
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
       return Objects.hash(number, brand);
    }
}
