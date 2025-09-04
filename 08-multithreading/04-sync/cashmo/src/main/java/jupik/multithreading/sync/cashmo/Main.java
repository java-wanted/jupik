package jupik.multithreading.sync.cashmo;

import jupik.multithreading.sync.cashpo.Cashpoint;
import jupik.multithreading.sync.cashpo.Request;
import jupik.multithreading.sync.cashpo.Runner;

public class Main
{
    public static void main(String []argv)
    {
        Cashpoint cash = new Multipoint(100);
        Request []req = {
            new Request(cash, "Abraam", 35),
            new Request(cash, "Isaack", 30),
            new Request(cash, "Moisha", 25),
            new Request(cash, "Saara", 40),
            new Request(cash, "Pahom", 10),
            new Request(cash, "Petia", 10),
            new Request(cash, "Prov", 5),
            new Request(cash, "Masha", 3),
            new Request(cash, "Vasia", 0),
        };

        int wanted = 0;
        for (Request r: req) {
            wanted += r.amount();
        }

        System.out.printf("Total %d\n", cash.total());
        System.out.printf("Wanted %d\n", wanted);
        System.out.printf("\n");

        Runner run = new Runner(req);
        run.start();

        try
        {
            run.join();
        }
        catch (InterruptedException e)
        {
            System.out.printf("Interrupted\n");
            System.exit(1);
        }

        int drawn = 0;
        wanted = 0;

        for (Request r: req)
        {
            if (r.result() != r.amount())
            {
                wanted += r.amount();
            }
            else
            {
                drawn += r.result();
            }
        }

        System.out.printf("\n");
        System.out.printf("Total %d\n", cash.total());
        System.out.printf("Drawn %d\n", drawn);
        System.out.printf("Wanted %d\n", wanted);
    }
}
