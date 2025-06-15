package jupik.oop.inher.cafs;

public class Cat
{
	protected boolean canEatHumans;
	protected int eyes;
	protected int legs;

	public Cat(boolean canEatHumans, int eyes, int legs)
	{
		this.canEatHumans = canEatHumans;
		this.eyes = eyes;
		this.legs = legs;
	}

	public int legs()
	{
		return legs;
	}

	public int eyes()
	{
		return eyes;
	}

	public boolean canEatHumans()
	{
		return canEatHumans;
	}
}
