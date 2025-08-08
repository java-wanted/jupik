package jupik.generics.intro.gbox;

import java.util.Objects;

public class Box<T>
{
    protected T value;

    public Box(T value)
    {
        this.value = value;
    }

    public Box()
    {
        this(null);
    }

    public T value()
    {
        return this.value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o != null && o instanceof Box<?> b) {
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

