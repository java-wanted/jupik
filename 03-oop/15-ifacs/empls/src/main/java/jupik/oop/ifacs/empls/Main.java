package jupik.oop.ifacs.empls;

import java.util.List;
import java.util.LinkedList;

public class Main
{
	public static void main(String []argv)
	{
		Employee []emps = {
			new Director(),
			new Coder(),
			new Cook(),
		};
		List<Workable> workers = new LinkedList<>();
		List<Delivering> drivers = new LinkedList<>();

		for (Employee e: emps)
		{
			if (e instanceof Workable w)
			{
				workers.add(w);
			}

			if (e instanceof Delivering d)
			{
				drivers.add(d);
			}
		}

		for (Workable w: workers)
		{
			System.out.printf("%s: ", ((Employee)w).position());
			w.work();
		}

		for (Delivering d: drivers)
		{
			System.out.printf("%s: ", ((Employee)d).position());
			d.deliver();
		}
	}
}
