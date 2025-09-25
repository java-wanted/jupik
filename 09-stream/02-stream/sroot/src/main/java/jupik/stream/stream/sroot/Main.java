package jupik.stream.stream.sroot;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main
{
    public static void main(String []argv)
    {
        int x0 = 100;
        int x1 = 200;
        int n = 1000;
        Random rand = new Random();
        List<Integer> nums = new LinkedList<>();

        rand.ints(n, x0, x1).forEach((v) -> nums.add(v));

        Predicate<Integer> div5 = (v) -> {
            return (v % 5) == 0;
        };
        Function<Integer, Double> sqrt = (v) -> {
            return Math.sqrt(v);
        };
        Function<Double, String> strg = (v) -> {
            return String.format("sroot:%.2f", v);
        };
        List<String> result = nums.stream()
            .filter(div5)
            .map(sqrt)
            .map(strg)
            .toList();

        for (String s: result)
        {
            System.out.printf("%s ", s);
        }

        System.out.printf("\n");
    }
}
