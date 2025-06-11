package jupik.oop.rpams.cbox;

import jupik.oop.parms.pbox.Pbox;

public class Cbox extends Pbox implements Comparable<Pbox>
{
	public static final double DEFAULT_SIZE = 10;

	Cbox(double height, double length, double width)
	{
		setDimensions(height, length, width);
	}

	Cbox(double size)
	{
		this(size, size, size);
	}

	Cbox()
	{
		this(DEFAULT_SIZE);
	}

	@Override
	public String toString()
	{
		return String.format(
			"height %.4f, length %.4f, width %.4f",
			height, length, width
		);
	}

	@Override
	public int compareTo(Pbox other)
	{
		return Double.compare(volume(), other.volume());
	}
}
