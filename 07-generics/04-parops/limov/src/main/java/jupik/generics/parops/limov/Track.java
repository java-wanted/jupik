package jupik.generics.parops.limov;

import jupik.generics.parms.pcols.List;

public class Track
{
    public static <T> void transfer(List<T> src, List<T> dst)
    {
        for (T e: src)
        {
            dst.add(e);
        }

        src.clear();
    }
}
