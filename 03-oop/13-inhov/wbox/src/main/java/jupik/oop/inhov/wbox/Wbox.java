package jupik.oop.inhov.wbox;

import jupik.oop.inhov.wbox.api.HavingWeight;
import jupik.oop.amods.abox.Box;

public class Wbox extends Box implements HavingWeight
{
	protected double weight;

	public Wbox(double height, double length, double width, double weight)
	{
		super(height, length, width);
		this.weight = weight;
	}

	public Wbox(double size, double weight)
	{
		super(size);
		this.weight = weight;
	}

	public Wbox(double weight)
	{
		this.weight = weight;
	}

	@Override
	public double weight()
	{
		return weight;
	}

	@Override
	public Object clone()
	{
		return new Wbox(height, length, width, weight);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null) {
			if (obj instanceof Wbox o) {
				return super.equals(o) &&
					weight == o.weight;
			}
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode() ^ Double.hashCode(weight);
	}

	@Override
	public String toString()
	{
		return String.format(
			"Wbox: height=%.4f, length=%4f, width=%4.f, weight=%.4f",
			height, length, width, weight
		);
	}
}
