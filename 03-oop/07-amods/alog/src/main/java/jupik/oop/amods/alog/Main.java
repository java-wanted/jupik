package jupik.oop.amods.alog;

import jupik.oop.amods.abox.Box;

public class Main
{
	public static void main(String []argv)
	{
		Box box = new Box(10, 20, 30);

		System.out.print(
			(new StringBuffer())
				.append("Box:\n")
				.append(String.format("    heigth %.4f\n", box.height()))
				.append(String.format("    length %.4f\n", box.length()))
				.append(String.format("    width  %.4f\n", box.width()))
				.append(String.format("    volume %.4f\n", box.volume()))
		);
	}
}
