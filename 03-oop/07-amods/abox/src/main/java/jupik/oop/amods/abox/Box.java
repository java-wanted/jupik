package jupik.oop.amods.abox;

import jupik.oop.amods.abox.api.HavingDimensions;
import jupik.oop.amods.abox.api.HavingVolume;

public class Box implements HavingDimensions, HavingVolume, Cloneable
{
	public static final double DEFAULT_SIZE = 10.0;

	protected double height;
	protected double length;
	protected double width;

	public Box(double height, double length, double width)
	{
		this.height = height;
		this.length = length;
		this.width = width;
	}

	public Box(double size)
	{
		this(size, size, size);
	}

	public Box()
	{
		this(DEFAULT_SIZE);
	}

	public double height()
	{
		return height;
	}

	public double length()
	{
		return length;
	}

	public double width()
	{
		return width;
	}

	public double volume()
	{
		return height * length * width;
	}

	@Override
	public Object clone()
	{
		return new Box(height, length, width);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null) {
			if (obj instanceof Box o) {
				return height == o.height &&
					length == o.length &&
					width == o.width;
			}
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		return Double.hashCode(height) ^ Double.hashCode(length) ^
			Double.hashCode(width);
	}

	@Override
	public String toString()
	{
		return String.format(
			"Box: height=%.4f, length=%4f, width=%4.f",
			height, length, width
		);
	}
}
