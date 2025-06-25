package jupik.oop.inhab.figs;

public class Rectangle extends Shape
{
	public Rectangle(double a, double b)
	{
		super(a, b);

		if (a <= 0 || b <= 0)
		{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double perimeter()
	{
		return a + a + b + b;
	}

	@Override
	public Object clone()
	{
		return new Rectangle(a, b);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj instanceof Rectangle o) {
			return a == o.a && b == o.b;
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		return Double.hashCode(a) ^ Double.hashCode(b);
	}
}
