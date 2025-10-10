package jupik.stream.streamk.leoper;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.Optional;
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
        Predicate<User> lowner = new Predicate<User>(){
            Pattern ptrn = Pattern.compile("[Ll]");

            public boolean test(User u)
            {
                return ptrn.matcher(u.name()).find();
            }
        };
        Optional<User> luser = users.stream().filter(lowner).findFirst();

        if (luser.isEmpty())
        {
            System.out.printf("There is no user her name contains 'l'.\n");
        }
        else
        {
            System.out.printf(
                "The first user her name contains 'l' is %s.\n",
                luser.get().name()
            );
        }
    }
}
