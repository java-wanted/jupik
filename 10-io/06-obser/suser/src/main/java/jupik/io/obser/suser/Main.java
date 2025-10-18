package jupik.io.obser.suser;

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
        File file = new File(dest, "user.bin");
        List<?> osers = List.of(
            new User("Abraam", "Levin", 70),
            new User("Isaak", "Putin", 75)
        );
        List<User> isers = null;

        dest.mkdirs();

        try (ObjectOutputStream fp = new ObjectOutputStream(
            new FileOutputStream(file)
        ))
        {
            fp.writeObject(osers);
        }
        catch (IOException e)
        {
            System.err.printf("Failed to write users: %s\n", e.getMessage());
            System.exit(1);
        }

        try (ObjectInputStream fp = new ObjectInputStream(
            new FileInputStream(file)
        ))
        {
            isers = ((List<?>)fp.readObject()).stream().map((o) -> (User)o).
                toList();
        }
        catch (ClassCastException | ClassNotFoundException | IOException e)
        {
            System.err.printf("Failed to read users: %s\n", e.getMessage());
            System.exit(1);
        }

        isers.stream().forEach(
            (u) -> System.out.printf(
                "%s %s %d\n", u.name(), u.lastname(), u.age()
            )
        );
    }
}
