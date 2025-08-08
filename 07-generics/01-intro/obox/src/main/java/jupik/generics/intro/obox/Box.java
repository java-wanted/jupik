package jupik.generics.intro.obox;

import java.util.Objects;

public class Box
{
    protected Object value;

    public Box(Object value)
    {
        this.value = value;
    }

    public Box()
    {
        this(null);
    }

    public Object value()
    {
        return this.value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o != null && o instanceof Box b) {
            return Objects.equals(b.value, value);
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }
}
