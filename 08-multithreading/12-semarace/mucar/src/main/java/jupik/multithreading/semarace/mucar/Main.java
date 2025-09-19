package jupik.multithreading.semarace.mucar;

import java.util.List;
import java.util.LinkedList;

public class Main
{
    static void printWinner(List<Race.Result> result)
    {
        long time = -1;
        int winner = -1;

        for (Race.Result r: result)
        {
            if (r.done() && time == -1 || r.time() < time)
            {
                winner = r.number();
                time = r.time();
            }
        }

        if (winner != -1)
        {
            System.out.printf("Winner %d, time %d\n", winner, time);
        }
    }

    static void printResult(List<Race.Result> result)
    {
        for (Race.Result r: result)
        {
            System.out.printf(
                "%d: time %s\n", r.number(), r.done() ? r.time() : "failed"
            );
        }
    }

    public static void main(String []argv)
    {
        int ncars = 10;
        List<Car> cars = new LinkedList<>();
        List<Race.Result> result = null;

        for (int i = 0; i < ncars; ++i)
        {
            cars.add(new Car());
        }

        try
        {
            result = Race.run(cars);
        }
        catch (InterruptedException e)
        {
            System.err.printf("Race Interrupted\n");
            return;
        }
        catch (Exception e)
        {
            System.err.printf("Race Failed: %s\n", e.getMessage());
            System.exit(1);
        }

        printWinner(result);
        printResult(result);
    }
}
