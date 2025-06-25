package jupik.oop.ifacs.empls;

public class Coder extends Employee implements Workable
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
}
