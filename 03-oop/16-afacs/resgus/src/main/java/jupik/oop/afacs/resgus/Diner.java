package jupik.oop.afacs.resgus;

public interface Diner
{
	default public void order(Waiter waiter, String dish)
	{
		waiter.bring(dish);
	}
}
