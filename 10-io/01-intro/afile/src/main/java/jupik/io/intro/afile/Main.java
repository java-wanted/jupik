package jupik.io.intro.afile;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Main
{
    static final String BASE_DIR = "output";

    static boolean create_files(File base, String dir, List<String> names)
    {
        File dp = new File(base, dir);

        dp.mkdirs();

        try
        {
            for (String name: names)
            {
                (new File(dp, name)).createNewFile();
            }
        }
        catch (IOException e)
        {
            System.err.printf(
                "Failed to create files: %s\n", e.getMessage()
            );
            return false;
        }

        return true;
    }

    static boolean list_files(File base, String path, Pattern ptrn)
    {
        FileFilter flt = (v) -> v.isDirectory() ||
            ptrn.matcher(v.getName()).matches();
        List<File> fps = new LinkedList<>();
        File ff = new File(base, path);

        if (flt.accept(ff))
        {
            fps.add(ff);
        }

        while (!fps.isEmpty())
        {
            File fp = fps.remove(0);

            if (fp.isFile())
            {
                String p = fp.getAbsolutePath();
                System.out.printf("%s\n", p);
            }
            else
            {
                File []fs = fp.listFiles(flt);

                if (fs == null)
                {
                    System.err.printf(
                        "Failed to list files within '%s'\n", fp.getPath()
                    );
                    return false;
                }

                fps.addAll(Arrays.asList(fs));
            }
        }

        return true;
    }

    public static void main(String []argv)
    {
        List<String> dnames = List.of(
            "d1", "d2", "d3"
        );
        String fdir = dnames.stream().collect(
            Collectors.joining(File.separator)
        );
        List<String> fnames = List.of(
            "A1", "B1", "A2", "B2"
        );
        Pattern ptrn = Pattern.compile("A.*");
        File base = new File(BASE_DIR);

        if (!create_files(base, fdir, fnames))
        {
            System.exit(1);
        }

        if (!list_files(base, dnames.get(0), ptrn))
        {
            System.exit(1);
        }
    }
}
