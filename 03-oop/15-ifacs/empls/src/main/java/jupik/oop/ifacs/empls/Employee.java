package jupik.oop.ifacs.empls;

public abstract class Employee
{
	protected String position;

	public Employee(String position)
	{
		this.position = position;
	}

	public String position()
	{
		return position;
	}
}
