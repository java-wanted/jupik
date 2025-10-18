package jupik.io.obser.cagrel;

import java.io.Serializable;
import java.util.Objects;

public class Cagrel implements Cat, Serializable
{
    public static final long serialVersionUID = 1L;

    protected String name;
    protected transient String breed;
    protected transient float weight;

    public Cagrel(String name, String breed, float weight)
    {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String name()
    {
        return name;
    }

    public String breed()
    {
        return breed;
    }

    public float weight()
    {
        return weight;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        else if (o == null)
        {
            return false;
        }
        else if (o instanceof Cagrel c)
        {
            return Objects.equals(name, c.name) &&
                Objects.equals(breed, c.breed) &&
                weight == c.weight;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, breed, weight);
    }
}
