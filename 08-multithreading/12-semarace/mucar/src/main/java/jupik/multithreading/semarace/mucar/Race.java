package jupik.multithreading.semarace.mucar;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.LinkedList;
import java.time.Clock;

public class Race
{
    public static record Result(int number, boolean done, long time)
    {
    }

    protected Clock clock;
    protected CountDownLatch ready;
    protected CountDownLatch start;
    protected Semaphore tunnel;
    protected List<Car> cars;

    protected Race(List<Car> cars)
    {
        clock = Clock.systemUTC();
        ready = new CountDownLatch(cars.size());
        start = new CountDownLatch(1);
        tunnel = new Semaphore(3);
        this.cars = cars;
    }

    protected void awaitReady() throws InterruptedException
    {
        ready.await();
    }

    protected void start()
    {
        start.countDown();
    }

    public Result drive(Car car)
    {
        try
        {
            car.prepare();
            ready.countDown();

            start.await();
            long before = clock.millis();

            car.drive("first");

            tunnel.acquire();
            try
            {
                car.drive("tunnel");
            }
            finally
            {
                tunnel.release();
            }

            car.drive("second");

            long after = clock.millis();

            car.finish();

            return new Result(car.number(), true, after - before);
        }
        catch (Exception e)
        {
            return new Result(car.number(), false, -1);
        }
    }

    public static List<Result> run(List<Car> cars) throws InterruptedException
    {
        ExecutorService pool = Executors.newFixedThreadPool(cars.size());
        List<Future<Result>> comp = new LinkedList<>();
        List<Result> result = new LinkedList<>();
        Race race = new Race(cars);
        int number = 0;
        boolean interrupted = false;
        boolean stopped = false;

        for (Car c: cars)
        {
            c.register(race, number++);
            comp.add(pool.submit(c));
        }

        try
        {
            race.awaitReady();
            race.start();

            for (Future<Result> c: comp)
            {
                result.add(c.get());
            }
        }
        catch (ExecutionException | InterruptedException e)
        {
            interrupted = true;
        }

        pool.shutdownNow();

        try
        {
            stopped = pool.awaitTermination(400, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
        }

        if (!stopped)
        {
            throw new RuntimeException("failed to terminate\n");
        }

        if (interrupted)
        {
            throw new InterruptedException();
        }

        return result;
    }
}
