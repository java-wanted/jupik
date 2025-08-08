package jupik.generics.intro.tbox;

import java.util.Objects;

public class Box<T1, T2, T3>
{
    protected T1 first;
    protected T2 second;
    protected T3 third;

    public Box(T1 first, T2 second, T3 third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Box()
    {
        this(null, null, null);
    }

    public T1 first()
    {
        return this.first;
    }

    public void setFirst(T1 value)
    {
         first = value;
    }

    public T2 second()
    {
        return this.second;
    }

    public void setSecond(T2 value)
    {
         second = value;
    }

    public T3 third()
    {
        return this.third;
    }

    public void setThird(T3 value)
    {
         third = value;
    }


    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Box<?, ?, ?> b) {
            return Objects.equals(b.first, first) &&
                Objects.equals(b.second, second) &&
                Objects.equals(b.third, third);
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(first, second, third);
    }
}

