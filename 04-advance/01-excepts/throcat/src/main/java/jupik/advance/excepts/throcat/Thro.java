package jupik.advance.excepts.throcat;

public class Thro implements Runnable
{
	@Override
	public  void run()
	{
		RuntimeException e = new ArrayIndexOutOfBoundsException();

		System.out.printf("Through the exception %s\n", e);

		throw e;
	}
}
