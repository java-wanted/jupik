package jupik.advance.excepts.throcat;

public class Cat
{
	public void run(Runnable r)
	{
		try
		{
			r.run();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.printf("Catch the exception %s\n", e);
		}
	}
}
