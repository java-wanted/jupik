package jupik.generics.extnds.ebox;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Number>
    /* Compare againts a box of any type */
    implements Comparable<Box<?>>
{
    protected ArrayList<T> items;

    /* Java compilers could not box elapsis of a generic type in a safe way */
    public Box(T []items)
    {
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    public void set(List<T> items)
    {
        this.items = new ArrayList<>(items);
    }

    public double mean()
    {
        final double []mean = new double[1];

        items.stream().forEach(
            (v) -> {
                /* Items MUST implement Number */
                mean[0] += v.doubleValue();
            }
        );

        return mean[0] / items.size();
    }

    @Override
    public int compareTo(Box<?> other)
    {
        return Double.compare(mean(), other.mean());
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Box<?> o)
        {
            /* The equality is transitive. Take hash codes into account */
            return mean() == o.mean();
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mean());
    }
}
