package jupik.multithreading.semarace.mucar;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Car implements Callable<Race.Result>
{
    protected Race race;
    protected int number;

    public void register(Race race, int number)
    {
        this.race = race;
        this.number = number;
    }

    public int number()
    {
        return number;
    }

    public void prepare() throws InterruptedException
    {
        System.out.printf("%d: prepare\n", number);
        Thread.sleep(
            ThreadLocalRandom.current().nextLong(400, 800)
        );
    }

    public void drive(String section) throws InterruptedException
    {
        System.out.printf("%d: drive %s\n", number, section);
        Thread.sleep(
            ThreadLocalRandom.current().nextLong(400, 800)
        );
    }

    public void finish()
    {
        System.out.printf("%d: finished\n", number);
    }

    public Race.Result call() throws Exception
    {
        return race.drive(this);
    }
}
