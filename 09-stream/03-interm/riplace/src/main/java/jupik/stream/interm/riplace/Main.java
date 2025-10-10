package jupik.stream.interm.riplace;

import java.util.function.Function;
import java.util.function.Predicate;
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
        Comparator<User> ledor = (u, v) -> {
            return u.name().compareToIgnoreCase(v.name());
        };
        Predicate<User> ripage = (u) -> u.age() > 40;
        int ripc = 3;
        Function<User, String> unam = (u) -> u.name();

        System.out.printf("There are %d users to be replaced:\n", ripc);
        users.stream().sorted(ledor).filter(ripage).limit(ripc)
            .map(unam).forEach((v) -> System.out.printf("  %s\n", v));
    }
}
