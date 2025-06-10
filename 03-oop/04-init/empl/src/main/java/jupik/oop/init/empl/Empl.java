package jupik.oop.init.empl;

import java.math.BigDecimal;

public class Empl
{
	protected String name;
	protected String position;
	protected BigDecimal salary;

	Empl(String name, String position, BigDecimal salary)
	{
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	void show()
	{
		System.out.print(
			new StringBuffer()
				.append(String.format("Name:     %s\n", name))
				.append(String.format("Position: %s\n", position))
				.append(String.format("Salary:   %s\n", salary.toPlainString()))
				.toString()
		);
	}
}
