package jupik.oop.ifacs.empls;

public class Director extends Employee implements Workable
{
	public Director()
	{
		super("Director");
	}

	@Override
	public void work()
	{
		System.out.printf("Her is directing.\n");
	}
}
