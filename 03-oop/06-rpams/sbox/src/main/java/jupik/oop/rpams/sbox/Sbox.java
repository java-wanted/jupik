package jupik.oop.rpams.sbox;

import jupik.oop.rpams.cbox.Cbox;

public class Sbox extends Cbox implements Cloneable
{
	public Sbox(double height, double length, double width)
	{
		super(height, length, width);
	}

	public Sbox(double size)
	{
		super(size);
	}

	public Sbox()
	{
		super();
	}

	@Override
	public Object clone()
	{
		return new Sbox(height, length, width);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null) {
			if (obj instanceof Sbox o) {
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
}
