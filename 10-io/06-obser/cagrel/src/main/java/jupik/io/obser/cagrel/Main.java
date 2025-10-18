package jupik.io.obser.cagrel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String []argv)
    {
        File dest = new File("output");
        File file = new File(dest, "cat.bin");
        List<Cat> pedi = List.of(
            new Cagrel("Abraam", "Egyptian", 7f),
            new Cagrel("Isaak", "Persian", 7.5f)
        );
        List<Cat> mutt = null;

        dest.mkdirs();

        try (ObjectOutputStream fp = new ObjectOutputStream(
            new FileOutputStream(file)
        ))
        {
            fp.writeObject(pedi);
        }
        catch (IOException e)
        {
            System.err.printf("Failed to write cats: %s\n", e.getMessage());
            System.exit(1);
        }

        try (ObjectInputStream fp = new ObjectInputStream(
            new FileInputStream(file)
        ))
        {
            mutt = ((List<?>)fp.readObject()).stream().map((o) -> (Cat)o)
                .toList();
        }
        catch (ClassCastException | ClassNotFoundException | IOException e)
        {
            System.err.printf("Failed to read cats: %s\n", e.getMessage());
            System.exit(1);
        }

        mutt.stream().forEach(
            (c) -> System.out.printf("%s\n", c.name())
        );
    }
}
