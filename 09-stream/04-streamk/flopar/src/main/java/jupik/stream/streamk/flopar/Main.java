package jupik.stream.streamk.flopar;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;
import java.time.Clock;

public class Main
{
    public static void main(String []argv)
    {
        Function<Float, Float> ftor = (v) -> {
            return (float)(
                Math.sin(0.2f + v / 5) + Math.cos(0.2f + v / 5) +
                Math.cos(0.4f + v / 2)
            );
        };
        int n = 3_000_000;
        List<Float> onums = IntStream.range(0, n).collect(
            () -> new ArrayList<Float>(n),
            (u, v) -> u.add((float)v),
            (u, v) -> { throw new RuntimeException(); }
        );
        Clock clock = Clock.systemUTC();

        long stime = clock.millis();
        int sn;
        float ssum;

        {
            List<Float> snums = onums.stream().map(ftor).collect(
                () -> new ArrayList<Float>(n),
                (u, v) -> u.add(v),
                (u, v) -> { throw new RuntimeException(); }
            );

            stime = clock.millis() - stime;
            sn = snums.size();
            ssum = snums.stream().reduce(Float::sum).get();
        }

        long ptime = clock.millis();
        int pn;
        float psum;

        {
            List<Float> pnums = onums.parallelStream().map(ftor).collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll
            );

            ptime = clock.millis() - ptime;
            pn = pnums.size();
            psum = pnums.stream().reduce(Float::sum).get();
        }

        System.out.printf(
            "%d floats have been evaluated sequentially in %d milliseconds.\n",
            sn, stime
        );
        System.out.printf("The total is %.4f.\n", ssum);

        System.out.printf(
            "%d floats have been evaluated in parallel in %d milliseconds\n",
            pn, ptime
        );
        System.out.printf("The total is %.4f.\n", psum);
    }
}
