package jupik.oop.inhab.figs;

public class Triangle extends Shape
{
	protected double c;

	public Triangle(double a, double b, double c)
	{
		super(a, b);

		if (
			a <= 0 || b <= 0 || c <= 0 ||
			a + b <= c || a + c <= b || b + c <= a
		) {
			throw new IllegalArgumentException();
		}

		this.c = c;
	}

	public double c()
	{
		return c;
	}

	@Override
	public double perimeter()
	{
		return a + b + c;
	}

	@Override
	public Object clone()
	{
		return new Triangle(a, b, c);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj instanceof Triangle o) {
			return a == o.a && b == o.b && c == o.c;
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		return Double.hashCode(a) ^ Double.hashCode(b) ^ Double.hashCode(c);
	}

	@Override
	public String toString()
	{
		return String.format("a=%.4f, b=%.4f, c=%.4f", a, b, c);
	}
}
