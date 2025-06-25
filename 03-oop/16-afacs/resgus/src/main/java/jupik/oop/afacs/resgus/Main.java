package jupik.oop.afacs.resgus;

public class Main
{
	static class JDiner implements Diner
	{
		String name;

		JDiner(String name)
		{
			this.name = name;
		}

		@Override
		public void order(Waiter w, String dish)
		{
			System.out.printf("%s ordered %s.\n", name, dish);
			w.bring(dish);
		}
	}

	static class JWaiter implements Waiter
	{
		String name;

		JWaiter(String name)
		{
			this.name = name;
		}

		@Override
		public void bring(String dish)
		{
			System.out.printf("%s brought %s.\n", name, dish);
		}
	}

	public static void main(String []argv)
	{
		Diner diner = new JDiner("Moisha");

		diner.order(new JWaiter("Vasia"), "matzah");
		diner.order(new Waiter()
			{
				@Override
				public void bring(String dish)
				{
					System.out.printf("Anonymous brought matzah.\n");
				}
			},
			"beacon"
		);
	}
}
