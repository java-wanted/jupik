package jupik.collections.tsets.decum;

import java.util.Random;
import java.util.TreeSet;

public class Main
{
    public static void main(String []argv)
    {
        final TreeSet<Integer> nums = new TreeSet<>(
            (a, b) -> -Integer.compare(a, b)
        );

        new Random().ints(100, 0, 10).forEach(
           (i) -> nums.add(i)
        );

        final StringBuffer s = new StringBuffer();

        nums.stream().forEach(
            (i) -> s.append(String.format("%d ", i))
        );

        System.out.printf("%s\n", s);
    }
}
