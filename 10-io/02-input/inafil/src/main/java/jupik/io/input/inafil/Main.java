package jupik.io.input.inafil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main
{
    public static void main(String []argv)
    {
        String path = "input/names.txt";
        int busiz = 0x100;
        byte []buf = new byte[busiz];

        try (InputStream fp = new FileInputStream(path))
        {
            while (true)
            {
                int n = fp.read(buf, 0, busiz);

                if (n == -1)
                    break;

                System.out.write(buf, 0, n);
            }
        }
        catch (IOException e)
        {
            System.err.printf("Failed to read names: %s\n", e.getMessage());
            System.exit(1);
        }
    }
}
