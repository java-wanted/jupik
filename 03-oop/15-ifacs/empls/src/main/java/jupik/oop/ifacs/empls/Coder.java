package jupik.oop.ifacs.empls;

public class Coder extends Employee implements Workable, Delivering
{
	public Coder()
	{
		super("Coder");
	}

	@Override
	public void work()
	{
		System.out.printf("Her is coding.\n");
	}

	@Override
	public void deliver()
	{
		System.out.printf("Her is delivering cooking.\n");
	}
}
