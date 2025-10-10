package jupik.stream.interm.termage;

import java.util.function.Predicate;
import java.util.List;

public class Main
{
    public static void main(String []argv)
    {
        List<User> users = List.of(
            new User("Abraam", 70),
            new User("Isaak", 80),
            new User("Saara", 90),
            new User("Vasia", 30)
        );
        Predicate<User> ripold = (v) -> v.age() > 35;
        long ripc = users.stream().filter(ripold).count();

        System.out.printf("There are %d rip old users:\n", ripc);
        users.stream().filter(ripold).forEach((v) -> {
            System.out.printf("  %s\n", v.name());
        });
    }
}
