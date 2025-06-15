package jupik.oop.inhab.figs;

public abstract class Shape
{
	protected double a;
	protected double b;

	public Shape(double a, double b)
	{
		this.a = a;
		this.b = b;
	}

	public double a()
	{
		return a;
	}

	public double b()
	{
		return b;
	}

	public abstract double perimeter();

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}

	@Override
	public String toString()
	{
		return String.format("a=%.4f, b=%.4f", a, b);
	}
}
