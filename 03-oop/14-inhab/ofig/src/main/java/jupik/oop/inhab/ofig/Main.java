package jupik.oop.inhab.ofig;

import jupik.oop.inhab.figs.Shape;
import jupik.oop.inhab.figs.Rectangle;
import jupik.oop.inhab.figs.Triangle;

public class Main
{
	static class ZShape extends Shape
	{
		public ZShape(double a, double b)
		{
			super(a, b);
		}

		public double perimeter()
		{
			return 0;
		}
	}

	static void ofig(Shape s)
	{
		if (s == null)
		{
			System.out.printf("<nil>\n");
		}
		else if (s instanceof Rectangle r)
		{
			System.out.printf(
				"Rectangle %.4f %.4f\n", r.a(), r.b()
			);
		}
		else if (s instanceof Triangle t)
		{
			System.out.printf(
				"Triangle %.4f %.4f %.4f\n", t.a(), t.b(), t.c()
			);
		}
		else
		{
			System.out.printf("Unknown Shape (%s)\n", s);
		}
	}

	public static void main(String []argv)
	{
		Shape []shapes = {
			new Rectangle(10, 20),
			new Triangle(10, 15, 20),
			null,
			new ZShape(10, 20),
		};

		System.out.printf("Shapes:\n");
		for (Shape s: shapes)
		{
			ofig(s);
		}

		System.out.printf("Perimeters:\n");
		for (Shape s: shapes)
		{
			if (s == null)
			{
				System.out.printf("<nil>\n");
			}
			else
			{
				System.out.printf("%.4f\n", s.perimeter());
			}
		}
	}
}
