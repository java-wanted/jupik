package jupik.stream.lambda.laker;

public class Main
{
    public static void main(String []argv)
    {
        Director d = new Director();

        d.makeWork(new Worker(){
            @Override
            public void work()
            {
                System.out.printf("An anonymous has started working.\n");
            }
        });

        d.makeWork(() -> {
            System.out.printf("An other anonymous has also started working.\n");
        });
    }
}
