package jupik.io.bufio.nascan;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    static final String PROMPT = "Write a name (or exit to terminate): ";
    static final String EXIT = "exit";
    static final int BUFSIZ = 0x10;

    static boolean make_dirs(File path)
    {
        File dir = path.getAbsoluteFile().getParentFile();

        if (dir == null)
        {
            return false;
        }
        else
        {
            dir.mkdirs();
            return true;
        }
    }

    static void scan_to_file(Scanner in, PrintStream out, PrintStream fp)
        throws IOException
    {
        while (true)
        {
            out.print(PROMPT);

            String s = in.nextLine().strip();
            if (s.isEmpty())
                continue;

            if (s.equals(EXIT))
                break;

            fp.println(s);
        }
    }

    static void read_to_out(InputStream fp, PrintStream out) throws IOException
    {
        byte []buf = new byte[BUFSIZ];

        while (true)
        {
            int n = fp.read(buf);

            if (n == -1)
                break;

            out.print(new String(buf, 0, n));
        }
    }

    public static void main(String []argv)
    {
        File path = new File("output/names.txt");

        if (!make_dirs(path))
        {
            System.out.printf("Failed to create directories\n");
            System.exit(1);
        }

        /* There is no dup operation in Java */
        Scanner in = new Scanner(System.in);

        try (PrintStream fp = new PrintStream(
            new FileOutputStream(path)
        ))
        {
            scan_to_file(in, System.out, fp);
        }
        catch (IOException e)
        {
            System.err.printf("Failed to write names: %s\n", e.getMessage());
            System.exit(1);
        }

        try (InputStream fp = new BufferedInputStream(
            new FileInputStream(path))
        )
        {
            read_to_out(fp, System.out);
        }
        catch (IOException e)
        {
            System.err.printf("Failed to read names: %s\n", e.getMessage());
            System.exit(1);
        }
    }
}
