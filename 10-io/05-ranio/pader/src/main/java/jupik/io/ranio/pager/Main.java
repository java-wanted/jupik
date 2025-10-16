package jupik.io.ranio.pader;

import java.io.RandomAccessFile;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    static final String EXIT = "exit";
    static final int PAGSIZ = 300;
    static final int BUFSIZ = 0x100;

    static long get_page_number(Scanner in, PrintStream out, long filsiz)
        throws IOException
    {
        long pages = (filsiz + PAGSIZ - 1) / PAGSIZ;
        long page = 0;

        while (true)
        {
            out.printf(
                "Write page from 1 to %d (or %s to terminate): ",
                pages, EXIT
            );

            String s = in.nextLine().strip();
            if (s.isEmpty())
                continue;

            if (s.equals(EXIT))
                return -1;

            try
            {
                page = Long.parseLong(s);
            }
            catch (NumberFormatException e)
            {
                out.printf("Invalid number '%s'\n", s);
                continue;
            }

            if (page < 1 || page > pages)
            {
                out.printf("The page %d is out of the document\n", page);
                continue;
            }

            return page - 1;
        }
    }

    static void print_page(RandomAccessFile fp, long page, PrintStream out)
        throws IOException
    {
        byte []buf = new byte[BUFSIZ];
        boolean eol = false;
        int p = 0;

        fp.seek(page * PAGSIZ);

        while (p < PAGSIZ)
        {
            int r = p + BUFSIZ <= PAGSIZ ? BUFSIZ : PAGSIZ - p;
            int n = fp.read(buf, 0, r);

            if (n == -1)
                break;

            String s = new String(buf, 0, n);
            out.print(s);

            eol = s.endsWith("\n");
            p += n;
        }

        if (!eol)
            out.println();
    }

    public static void main(String []argv)
    {
        if (argv.length != 1)
        {
            System.err.printf("The document is not specified\n");
            System.exit(1);
        }

        File path = new File(argv[0]);
        if (!path.isFile())
        {
            System.err.printf("Path \"%s\" is invalid\n", path.getPath());
            System.exit(1);
        }

        /* There is no dup operation in Java */
        Scanner sc = new Scanner(System.in);

        try (RandomAccessFile fp = new RandomAccessFile(path, "r"))
        {
            while (true)
            {
                long page = get_page_number(sc, System.out, fp.length());

                if (page == -1)
                    break;

                print_page(fp, page, System.out);
            }
        }
        catch (IOException e)
        {
            System.err.printf("Failed to print: %s\n", e.getMessage());
            System.exit(1);
        }
    }
}
