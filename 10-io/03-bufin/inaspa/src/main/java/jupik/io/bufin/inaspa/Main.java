package jupik.io.bufin.inaspa;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    static final int BUFSIZ = 0x8;

    static List<String> read_names(Reader fp) throws IOException
    {
        List<String> names = new LinkedList<>();
        StringBuilder name = new StringBuilder();
        char []buf = new char[BUFSIZ];
        int n;

        do
        {
            n = fp.read(buf, 0, buf.length);

            for (int i = 0; i < n; ++i)
            {
                if (buf[i] == '\n')
                {
                    /* Read the first line only */
                    n = -1;
                    break;
                }

                if (buf[i] != ' ')
                {
                    /* The names are space separated */
                    name.append(buf[i]);
                }
                else
                {
                    if (name.length() > 0)
                    {
                        names.add(name.toString());
                        name.delete(0, name.length());
                    }
                }
            }
        }
        while (n != -1);

        if (name.length() > 0)
        {
            names.add(name.toString());
        }

        return names;
    }

    public static void main(String []argv)
    {
        String path = "input/names.txt";
        char letter = 'A';
        List<String> names = null;
        Predicate<String> nafil = (v) -> v.charAt(0) == letter;
        Comparator<String> nacom = (u, v) -> u.compareTo(v);

        try (Reader fp = new InputStreamReader(new FileInputStream(path)))
        {
            names = read_names(fp);
        }
        catch (IOException e)
        {
            System.err.printf("Failed to read names: %s\n", e.getMessage());
            System.exit(1);
        }

        names.stream().filter(nafil).sorted(nacom).forEach(
            (v) -> System.out.printf("%s\n", v)
        );
    }
}
