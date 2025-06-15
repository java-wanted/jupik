package jupik.oop.inhov.wlog;

import jupik.oop.amods.abox.Box;
import jupik.oop.inhov.wbox.Wbox;

public class Main
{
	static void print(Box box)
	{
		StringBuffer s = new StringBuffer();

		s.append("Box:\n");
		s.append(String.format("    heigth %.4f\n", box.height()));
		s.append(String.format("    length %.4f\n", box.length()));
		s.append(String.format("    width  %.4f\n", box.width()));

		if (box instanceof Wbox wbox)
		{
			s.append(String.format(
				"    weight %.4f\n", wbox.weight()
			));
		}

		System.out.printf("%s", s);
	}
	
	public static void main(String []argv)
	{
		Box []box = {
			new Box(10, 20, 30),
			new Wbox(10, 20, 30, 40),
		};

		for (Box b: box)
		{
			print(b);
		}
	}
}
