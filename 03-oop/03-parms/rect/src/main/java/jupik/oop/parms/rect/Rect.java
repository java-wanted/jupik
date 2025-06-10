package jupik.oop.parms.rect;

public class Rect
{
	protected float length;
	protected float width;

	@Override
	public String toString()
	{
		return String.format(
			"length %.4f, width %.4f", length, width
		);
	}

	public void setDimensions(float length, float width)
	{
		this.length = length;
		this.width = width;
	}

	public double area()
	{
		return length * width;
	}
}
