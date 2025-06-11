package jupik.oop.rpams.dbox;

import jupik.oop.rpams.sbox.Sbox;

public class Dbox extends Sbox
{
	public Dbox(double height, double length, double width)
	{
		super(height, length, width);
	}

	public Dbox(double size)
	{
		super(size);
	}

	public Dbox()
	{
		super();
	}

	public Dbox doubleDimensions()
	{
		return new Dbox(height * 2, length * 2, width * 2);
	}
}
