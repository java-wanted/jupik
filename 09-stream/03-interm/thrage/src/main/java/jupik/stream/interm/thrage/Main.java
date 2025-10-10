package jupik.stream.interm.thrage;

import java.util.Comparator;
import java.util.List;
import jupik.stream.interm.termage.User;

public class Main
{
    public static void main(String []argv)
    {
        List<User> users = List.of(
            new User("Abraam", 70),
            new User("Iliaa", 60),
            new User("Isaak", 80),
            new User("Saara", 90),
            new User("Vasia", 30)
        );
        Comparator<User> oldor = (u, v) -> {
            return -Integer.compare(u.age(), v.age());
        };
        int ripc = 3;

        System.out.printf("There are %d oldest users:\n", ripc);
        users.stream().sorted(oldor).limit(ripc).forEach((v) -> {
            System.out.printf("  %s of %d\n", v.name(), v.age());
        });
    }
}
