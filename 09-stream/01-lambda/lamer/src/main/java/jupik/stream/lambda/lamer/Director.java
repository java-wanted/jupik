package jupik.stream.lambda.lamer;

public class Director
{
    public String makeWork(Worker worker, int times)
    {
        return worker.work(times);
    }
}
