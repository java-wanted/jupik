package jupik.stream.lambda.lafer;

import java.util.function.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main
{
    static List<Integer> filter(List<Integer> nums, Predicate<Integer> p)
    {
        List<Integer> result = new LinkedList<>();

        for (Integer v: nums)
        {
            if (p.test(v))
            {
                result.add(v);
            }
        }

        return result;
    }

    public static void main(String []argv)
    {
        Random rand = new Random();
        List<Integer> nums = new LinkedList<>();

        rand.ints(10, 0, 10).forEach((v) -> nums.add(v));

        List<Integer> result = filter(nums, (v) -> (v & 1) == 0);

        System.out.printf("There are %d even numbers:\n", result.size());

        for (Integer v: result)
        {
            System.out.printf("%d ", v);
        }

        System.out.printf("\n");
    }
}
