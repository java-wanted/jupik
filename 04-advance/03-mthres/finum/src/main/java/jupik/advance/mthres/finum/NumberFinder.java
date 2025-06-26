package jupik.advance.mthres.finum;

import java.io.IOException;

public interface NumberFinder extends Runnable
{
	public boolean await(long msecs) throws InterruptedException;
	public int value() throws IOException;
}
