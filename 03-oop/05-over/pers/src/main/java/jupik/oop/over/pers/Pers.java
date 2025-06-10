package jupik.oop.over.pers;

public class Pers
{
	public static final int DEFAULT_COUNT = 2;
	public static final String DEFAULT_VOICE = "Grrr...";

	protected int eyes;
	protected int hands;
	protected int legs;

	Pers(int eyes, int hands, int legs)
	{
		this.eyes = eyes;
		this.hands = hands;
		this.legs = legs;
	}

	Pers(int count)
	{
		this(count, count, count);
	}

	Pers()
	{
		this(DEFAULT_COUNT);
	}

	@Override
	public String toString()
	{
		return String.format("eyes %d, hands %d, legs %d", eyes, hands, legs);
	}

	void voice(int count, String voice)
	{
		while (count-- > 0) {
			System.out.printf("%s\n", voice);
		}
	}

	void voice(int count)
	{
		voice(count, DEFAULT_VOICE);
	}

	void voice()
	{
		voice(1);
	}
}
