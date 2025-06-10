package jupik.oop.parms.pbox;

import jupik.oop.intro.box.Box;

public class Pbox extends Box {
	public void setDimensions(double height, double length, double width)
	{
		this.height = height;
		this.length = length;
		this.width = width;
	}

	public double volume()
	{
		return height * length * width;
	}
}
