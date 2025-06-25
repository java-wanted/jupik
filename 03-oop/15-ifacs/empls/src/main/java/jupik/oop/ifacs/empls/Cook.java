package jupik.oop.ifacs.empls;

public class Cook extends Employee implements Workable
{
	public Cook()
	{
		super("Cook");
	}

	@Override
	public void work()
	{
		System.out.printf("Her is cooking.\n");
	}
}
