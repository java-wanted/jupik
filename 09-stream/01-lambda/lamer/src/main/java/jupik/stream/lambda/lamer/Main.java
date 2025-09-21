package jupik.stream.lambda.lamer;

public class Main
{
    public static void main(String []argv)
    {
        Director d = new Director();
        Worker w = (times) -> {
            return String.format(
                "An anonymous has started working %d time(s).", times
            );
        };
        String result = d.makeWork(w, 5);

        System.out.printf("%s\n", result);
    }
}
