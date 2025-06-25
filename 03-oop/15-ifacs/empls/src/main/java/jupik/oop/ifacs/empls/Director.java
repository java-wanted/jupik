package jupik.oop.ifacs.empls;

public class Director extends Employee implements Workable, Delivering
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

	@Override
	public void deliver()
	{
		System.out.printf("Her is delivering cooking.\n");
	}
}
